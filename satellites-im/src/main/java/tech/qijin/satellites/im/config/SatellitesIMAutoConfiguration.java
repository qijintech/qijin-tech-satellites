package tech.qijin.satellites.im.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Configuration
@ComponentScan(basePackages = "tech.qijin.satellites.im")
public class SatellitesIMAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("======= loading Satellites IM =======");
    }
}
