package tech.qijin.satellites.comments.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author UnitTest
 */

@SpringBootApplication(scanBasePackages = {"tech.qijin.satellites.comments"})
@MapperScan("tech.qijin.satellites.comments.db.dao")
public class SatellitesCommentsTest {

    public static void main(String[] args) {
        SpringApplication.run(SatellitesCommentsTest.class, args);
    }
}
