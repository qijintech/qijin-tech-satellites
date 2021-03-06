package tech.qijin.satellites.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
public class WebSocketPropertiesConfig {
    @Profile("dev")
    @Configuration
    @PropertySource("classpath:websocket-dev.properties")
    public static class DevConfiguration{
    }

    @Profile("test")
    @Configuration
    @PropertySource("classpath:websocket-test.properties")
    public static class TestConfiguration{
    }

    @Profile("prod")
    @Configuration
    @PropertySource("classpath:websocket-prod.properties")
    public static class ProdConfiguration{
    }
}
