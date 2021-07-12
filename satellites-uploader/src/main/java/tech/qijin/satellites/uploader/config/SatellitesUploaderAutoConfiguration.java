package tech.qijin.satellites.uploader.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.qijin.util4j.web.config.AutoConfiguration;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Configuration
@ComponentScan(basePackages = "tech.qijin.satellites.uploader")
public class SatellitesUploaderAutoConfiguration extends AutoConfiguration {
    @Override
    public String module() {
        return "SatellitesUploaderAutoConfiguration";
    }
}
