package tech.qijin.satellites.user.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.service.UserInfoService;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;
import tech.qijin.satellites.user.service.helper.UserInfoHelper;

/**
 * @author michealyang
 * @date 2019/1/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class UserInfoServiceTest extends BaseTest{
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserAccountHelper userAccountHelper;
    @Autowired
    private UserInfoHelper userInfoHelper;

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UserUtil.getUserId());
        userInfo.setAddress("北京🙄");
        boolean res = userInfoService.updateInfoByUserId(userInfo);
        Assert.assertTrue(res);
    }
}
