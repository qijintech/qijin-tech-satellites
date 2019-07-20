package tech.qijin.satellites.favorites.config;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.qijin.satellites.favorites.spi.FavoritesProvider;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
public class FavoritesSpiConfiguration {
    @Bean(value = "favoritesServiceFactory")
    public ServiceListFactoryBean serviceListFactoryBean() {
        ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
        serviceListFactoryBean.setServiceType(FavoritesProvider.class);
        return serviceListFactoryBean;
    }
}
