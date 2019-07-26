package tech.qijin.satellites.websocket.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@ConfigurationProperties(prefix = "websocket.netty")
@Data
public class WebSocketProperties {
    private Integer port = 3301;
    private String uri = "/connect";
}
