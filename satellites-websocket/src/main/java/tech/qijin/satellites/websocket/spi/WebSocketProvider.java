package tech.qijin.satellites.websocket.spi;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface WebSocketProvider {
    /**
     * @param token
     * @return uid
     */
    Long authToken(String token);

    /**
     * 处理消息
     *
     * @param userId
     * @param msg
     */
    void handleMsg(Long userId, String msg);
}
