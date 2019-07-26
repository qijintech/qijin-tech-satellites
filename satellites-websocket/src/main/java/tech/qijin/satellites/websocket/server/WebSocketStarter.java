package tech.qijin.satellites.websocket.server;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.websocket.config.WebSocketProperties;
import tech.qijin.util4j.utils.LogFormat;

/**
 * @author michealyang
 * @date 2019/1/28
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Component
@Slf4j
public class WebSocketStarter {

    @Autowired
    private WebSocketProperties properties;
    @Autowired
    private WebSocketServerInitializer initializer;

    @PostConstruct
    public void init() {
        new Thread(new WebsocketServer(properties, initializer)).start();
        log.info(LogFormat.builder().message("starting WebSocket").build());
    }
}
