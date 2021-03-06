package tech.qijin.satellites.websocket.server;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import tech.qijin.util4j.utils.LogFormat;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author michealyang
 * @date 2019/1/26
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
public class WebSocketUserHolder {

    private static final AttributeKey<Long> USER_ATTR_KEY =
            AttributeKey.valueOf(Long.class, "USER_KEY");

    private static ConcurrentHashMap<Long, Channel> userChannelMap
            = new ConcurrentHashMap<>();

    public static void add(Long uid, Channel channel) {
        Channel oldChannel = userChannelMap.put(uid, channel);
        if (oldChannel != null) {
            log.warn(LogFormat.builder().message("multiple WebSocket connection from same user")
                    .put("uid", uid).build());
            oldChannel.close();
        }
        channel.attr(USER_ATTR_KEY).set(uid);
    }

    public static void remove(Channel channel) {
        Long userId = getUserId(channel);
        if (userId != null) {
            userChannelMap.remove(userId);
        }
    }

    public static Optional<Channel> getChannel(Long uid) {
        return Optional.ofNullable(userChannelMap.get(uid));
    }

    public static Long getUserId(Channel channel) {
        return channel.attr(USER_ATTR_KEY).get();
    }
}
