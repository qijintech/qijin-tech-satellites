package tech.qijin.satellites.rank.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author UnitTest
 */

@SpringBootApplication(scanBasePackages = {"tech.qijin.satellites.comments"})
@MapperScan("tech.qijin.satellites.comments.db.dao")
public class SatellitesRankTest {

    public static void main(String[] args) {
        SpringApplication.run(SatellitesRankTest.class, args);
    }
}
