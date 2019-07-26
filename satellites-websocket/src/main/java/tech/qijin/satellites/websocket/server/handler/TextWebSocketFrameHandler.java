package tech.qijin.satellites.websocket.server.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.websocket.server.WebSocketUserHolder;
import tech.qijin.satellites.websocket.spi.WebSocketProvider;
import tech.qijin.util4j.utils.LogFormat;

/**
 * @author michealyang
 * @date 2019/1/25
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@ChannelHandler.Sharable
@Component
@Slf4j
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Autowired
    private WebSocketProvider webSocketProvider;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        log.info("msg={}", msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("response:" + msg.text()));
        if ("close".equals(msg.text())) {
            ChannelFuture closeFuture = ctx.channel().close();
            closeFuture.addListener(
                    future -> log.info(LogFormat.builder().message("WebSocket is closed").build()));
        }
        Long userId = WebSocketUserHolder.getUserId(ctx.channel());
        webSocketProvider.handleMsg(userId, msg.text());
    }
}
