package tech.qijin.satellites.user.test;

import org.springframework.beans.factory.annotation.Autowired;
//import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;

/**
 * @author michealyang
 * @date 2019/1/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public class UserProfileBoServiceTest extends BaseTest{
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserAccountHelper userAccountHelper;
//    @Autowired
//    private UserInfoHelper userInfoHelper;

//    @Test
//    public void update() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(UserUtil.getUserId());
//        userInfo.setAddress("北京🙄");
//        boolean res = userInfoService.updateInfoByUserId(userInfo);
//        Assert.assertTrue(res);
//    }
}
