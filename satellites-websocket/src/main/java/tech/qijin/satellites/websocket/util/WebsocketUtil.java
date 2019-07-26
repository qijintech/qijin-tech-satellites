package tech.qijin.satellites.websocket.util;

import java.util.Optional;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.websocket.server.WebSocketUserHolder;
import tech.qijin.util4j.utils.LogFormat;

/**
 * @author michealyang
 * @date 2019/1/29
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
public class WebsocketUtil {

    public static boolean send(Long userId, String msg) {
        Optional<Channel> channelOpt = WebSocketUserHolder.getChannel(userId);
        return channelOpt.map(channel -> {
            TextWebSocketFrame textFrame = new TextWebSocketFrame(msg);
            channel.writeAndFlush(textFrame);
            log.info(LogFormat.builder().message("msg sent through websocket")
                    .put("userId", userId).put("msg", msg).build());
            return true;
        }).orElseGet(() -> {
            log.info(LogFormat.builder().message("no user found")
                    .put("userId", userId).build());
            return false;
        });
    }
}
