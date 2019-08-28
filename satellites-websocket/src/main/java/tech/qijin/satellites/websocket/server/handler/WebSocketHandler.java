package tech.qijin.satellites.websocket.server.handler;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.Utf8FrameValidator;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.websocket.config.WebSocketProperties;
import tech.qijin.satellites.websocket.server.WebSocketUserHolder;
import tech.qijin.satellites.websocket.spi.WebSocketProvider;
import tech.qijin.util4j.lang.constant.Const;
import tech.qijin.util4j.trace.pojo.EnvEnum;
import tech.qijin.util4j.trace.util.EnvUtil;
import tech.qijin.util4j.trace.util.TraceUtil;
import tech.qijin.util4j.utils.LogFormat;


/**
 * @author michealyang
 * @date 2019/1/25
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@ChannelHandler.Sharable
@Component
@Slf4j
public class WebSocketHandler extends WebSocketProtocolHandler {
    @Autowired
    private WebSocketProvider webSocketProvider;
    @Autowired
    private WebSocketProperties webSocketProperties;

    /**
     * Events that are fired to notify about handshake status
     */
    public enum ServerHandshakeStateEvent {
        /**
         * The Handshake was completed successfully and the channel was upgraded to websockets.
         *
         * @deprecated in favor of {@link WebSocketServerProtocolHandler.HandshakeComplete} class,
         * it provides extra information about the handshake
         */
        @Deprecated
        HANDSHAKE_COMPLETE
    }

    /**
     * The Handshake was completed successfully and the channel was upgraded to websockets.
     */
    public static final class HandshakeComplete {
        private final String requestUri;
        private final HttpHeaders requestHeaders;
        private final String selectedSubprotocol;

        HandshakeComplete(String requestUri, HttpHeaders requestHeaders, String selectedSubprotocol) {
            this.requestUri = requestUri;
            this.requestHeaders = requestHeaders;
            this.selectedSubprotocol = selectedSubprotocol;
        }

        public String requestUri() {
            return requestUri;
        }

        public HttpHeaders requestHeaders() {
            return requestHeaders;
        }

        public String selectedSubprotocol() {
            return selectedSubprotocol;
        }
    }

    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY =
            AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
    private static final AttributeKey<String> TRACE_ATTR_KEY =
            AttributeKey.valueOf(String.class, "TRACE");
    private static final AttributeKey<EnvEnum> ENV_ATTR_KEY =
            AttributeKey.valueOf(EnvEnum.class, "ENV");

    private final String websocketPath;
    private final String subprotocols;
    private final boolean allowExtensions;
    private final int maxFramePayloadLength;
    private final boolean allowMaskMismatch;
    private final boolean checkStartsWith;

    public WebSocketHandler() {
        this(null, null, false);
    }

    public WebSocketHandler(String websocketPath) {
        this(websocketPath, null, false);
    }

    public WebSocketHandler(String websocketPath, boolean checkStartsWith) {
        this(websocketPath, null, false, 65536, false, checkStartsWith);
    }

    public WebSocketHandler(String websocketPath, String subprotocols) {
        this(websocketPath, subprotocols, false);
    }

    public WebSocketHandler(String websocketPath, String subprotocols, boolean allowExtensions) {
        this(websocketPath, subprotocols, allowExtensions, 65536);
    }

    public WebSocketHandler(String websocketPath, String subprotocols,
                            boolean allowExtensions, int maxFrameSize) {
        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, false);
    }

    public WebSocketHandler(String websocketPath, String subprotocols,
                            boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch) {
        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, true);
    }

    public WebSocketHandler(String websocketPath, String subprotocols,
                            boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch, boolean checkStartsWith) {
        this(websocketPath, subprotocols, allowExtensions, maxFrameSize, allowMaskMismatch, checkStartsWith, true);
    }

    public WebSocketHandler(String websocketPath, String subprotocols,
                            boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch,
                            boolean checkStartsWith, boolean dropPongFrames) {
        super(dropPongFrames);
        this.websocketPath = websocketPath;
        this.subprotocols = subprotocols;
        this.allowExtensions = allowExtensions;
        maxFramePayloadLength = maxFrameSize;
        this.allowMaskMismatch = allowMaskMismatch;
        this.checkStartsWith = checkStartsWith;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        ChannelPipeline cp = ctx.pipeline();
        if (cp.get(WebSocketHandshakeHandler.class) == null) {
            // Add the WebSocketHandshakeHandler before this one.
            ctx.pipeline().addBefore(ctx.name(), WebSocketHandshakeHandler.class.getName(),
                    new WebSocketHandshakeHandler(webSocketProvider, webSocketProperties.getUri(), subprotocols,
                            allowExtensions, maxFramePayloadLength, allowMaskMismatch, checkStartsWith));
        }
        if (cp.get(Utf8FrameValidator.class) == null) {
            // Add the UFT8 checking before this one.
            ctx.pipeline().addBefore(ctx.name(), Utf8FrameValidator.class.getName(),
                    new Utf8FrameValidator());
        }
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, WebSocketFrame frame, List<Object> out) throws Exception {
        if (frame instanceof CloseWebSocketFrame) {
            TraceUtil.setTraceId(getTraceId(ctx.channel()));
            log.info(LogFormat.builder().message("closing websocket")
                    .put("userId", WebSocketUserHolder.getUserId(ctx.channel())).build());
            WebSocketServerHandshaker handshaker = getHandshaker(ctx.channel());
            if (handshaker != null) {
                frame.retain();
                WebSocketUserHolder.remove(ctx.channel());
                handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame);
            } else {
                ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
            }
            return;
        }
        super.decode(ctx, frame, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof WebSocketHandshakeException) {
            FullHttpResponse response = new DefaultFullHttpResponse(
                    HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(cause.getMessage().getBytes()));
            ctx.channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        } else {
            ctx.fireExceptionCaught(cause);
            ctx.close();
        }
    }

    static WebSocketServerHandshaker getHandshaker(Channel channel) {
        return channel.attr(HANDSHAKER_ATTR_KEY).get();
    }

    static void setHandshaker(Channel channel, WebSocketServerHandshaker handshaker) {
        channel.attr(HANDSHAKER_ATTR_KEY).set(handshaker);
    }

    public static void setTraceIdAndEnv(Channel channel, FullHttpRequest req) {
        EnvEnum env = req.uri().startsWith(Const.ENV_VIRTUAL_HOST) ? EnvEnum.TEST : EnvEnum.PRODUCT;
        TraceUtil.setTraceId();
        EnvUtil.setEnv(env);
        channel.attr(TRACE_ATTR_KEY).set(TraceUtil.getTraceId());
        channel.attr(ENV_ATTR_KEY).set(EnvUtil.getEnv());
    }

    public static String getTraceId(Channel channel) {
        return channel.attr(TRACE_ATTR_KEY).get();
    }

    public static EnvEnum getEnv(Channel channel) {
        return channel.attr(ENV_ATTR_KEY).get();
    }

    static ChannelHandler forbiddenHttpRequestResponder() {
        return new ChannelInboundHandlerAdapter() {
            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                if (msg instanceof FullHttpRequest) {
                    ((FullHttpRequest) msg).release();
                    FullHttpResponse response =
                            new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.FORBIDDEN);
                    ctx.channel().writeAndFlush(response);
                } else {
                    ctx.fireChannelRead(msg);
                }
            }
        };
    }
}
