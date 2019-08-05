package tech.qijin.satellites.rank.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.qijin.satellites.rank.service.RankService;

public class RankServiceTest extends BaseTest {
    @Autowired
    private RankService rankService;

    @Test
    public void fire() {
        String member = "micheal";
        Long score = 100L;
        rankService.fire(member, score);
    }
}
