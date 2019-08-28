package tech.qijin.satellites.user.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

/**
 * @author UnitTest
 */

@SpringBootApplication(scanBasePackages = {"tech.qijin.satellites.user"},
        exclude = PageHelperAutoConfiguration.class)
@MapperScan("tech.qijin.satellites.user.db.dao")
public class ApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }
}
