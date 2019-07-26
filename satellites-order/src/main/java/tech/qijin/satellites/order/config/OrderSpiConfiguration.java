package tech.qijin.satellites.order.config;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.qijin.satellites.order.service.spi.OrderServiceProvider;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
public class OrderSpiConfiguration {
    @Bean(value = "orderServiceFactory")
    public ServiceListFactoryBean serviceListFactoryBean() {
        ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(OrderServiceProvider.class);
        return serviceListFactoryBean;
    }
}
