package tech.qijin.satellites.user.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;
import tech.qijin.satellites.user.service.helper.UserInfoHelper;

/**
 * @author michealyang
 * @date 2019/1/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class UserAccountServiceTest extends BaseTest{
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserAccountHelper userAccountHelper;
    @Autowired
    private UserInfoHelper userInfoHelper;


    /**
     * 手机号成功注册
     */
    @Test
    public void signUp_1() {
        String userName = "18810442532";
        String password = "123456";
        userAccountService.signUp(userName, password, false);
    }

    /**
     * 邮箱成功注册
     */
    @Test
    public void signUp_2() {
        String userName = "michealyang@aliyun.com";
        String password = "123456";
        userAccountService.signUp(userName, password, false);
    }

    @Test
    public void signIn_1() {
        String userName = UserUtil.getUser().getUserName();
        String password = "123456";
        UserBo userBo = userAccountService.signIn(userName, password);
        log.info("userBo={}", userBo);
    }
}
