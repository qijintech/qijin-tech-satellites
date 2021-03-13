package tech.qijin.satellites.user.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.qijin.satellites.user.auth.UserInterceptorConfiguration;

import javax.annotation.PostConstruct;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Configuration
@Import({UserInterceptorConfiguration.class})
@ComponentScan(basePackages = "tech.qijin.satellites.user")
public class SatellitesUserAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("======= loading Satellites User =======");
    }
}
