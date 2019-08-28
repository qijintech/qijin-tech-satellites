package tech.qijin.satellites.websocket.config;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.qijin.satellites.websocket.spi.WebSocketProvider;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
public class WebSocketSpiConfiguration {
    @Bean(value = "webSocketServiceFactory")
    public ServiceListFactoryBean serviceListFactoryBean() {
        ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(WebSocketProvider.class);
        return serviceListFactoryBean;
    }
}
