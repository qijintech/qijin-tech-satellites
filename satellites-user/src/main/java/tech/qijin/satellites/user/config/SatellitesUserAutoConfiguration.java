package tech.qijin.satellites.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.qijin.satellites.user.auth.UserInterceptorConfiguration;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
@Import({UserInterceptorConfiguration.class})
@ComponentScan(basePackages = "tech.qijin.satellites.user")
@MapperScan("tech.qijin.satellites.user.db.dao")
public class SatellitesUserAutoConfiguration {
}
