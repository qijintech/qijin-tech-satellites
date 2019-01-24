package tech.qijin.satellites.favorites.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
@Import(SpiConfiguration.class)
@ComponentScan(basePackages = "tech.qijin.satellites.favorites")
@MapperScan("tech.qijin.satellites.favorites.db.dao")
public class SatellitesFavoritesAutoConfiguration {
}
