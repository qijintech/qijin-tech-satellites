package tech.qijin.satellites.user.test;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.auth.pojo.User;
import tech.qijin.util4j.trace.pojo.Channel;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.trace.util.TraceUtil;

/**
 * @author UnitTest
 * @date 2018/11/2
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@Transactional
@Rollback(value = false)
@ActiveProfiles(profiles = "dev")
public class BaseTest {
    protected static final Logger log = LoggerFactory.getLogger("TEST");
    @BeforeClass
    public static void beforeClass() {
        ChannelUtil.setChannel(Channel.TEST);
        User user = new User();
        user.setUserId(1L);
        user.setUserName("UnitTest");
        user.setChannel(Channel.TEST);
        UserUtil.setUser(user);
        TraceUtil.setTraceId(UUID.randomUUID().toString());
    }
}
