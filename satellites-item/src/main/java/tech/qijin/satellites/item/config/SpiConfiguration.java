package tech.qijin.satellites.item.config;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.qijin.satellites.item.service.spi.ItemServiceProvider;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
public class SpiConfiguration {
    @Bean
    public ServiceListFactoryBean serviceListFactoryBean() {
        ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(ItemServiceProvider.class);
        return serviceListFactoryBean;
    }
}
