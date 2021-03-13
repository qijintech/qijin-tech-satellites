package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.cell.user.base.EmailRegisterVo;
import tech.qijin.cell.user.base.RegisterType;
import tech.qijin.cell.user.base.UserSessionBo;
import tech.qijin.cell.user.service.CellUserAccountService;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;
import tech.qijin.util4j.aop.annotation.Log;
import tech.qijin.util4j.aop.annotation.Timed;


/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private CellUserAccountService cellUserAccountService;

    @Timed
    @Log
    @Transactional
    @Override
    public String signUp(String userName, String password, Boolean signIn) {
        EmailRegisterVo emailRegisterVo = new EmailRegisterVo();
        emailRegisterVo.setEmail(userName);
        emailRegisterVo.setPassword(password);
        UserSessionBo userSessionBo = cellUserAccountService.register(RegisterType.EMAIL, emailRegisterVo, signIn, 3);
        if (signIn) {
            return userSessionBo.getUserToken().getToken();
        }
        return "";
    }

    @Timed
    @Log
    @Override
    public UserBo signIn(String userName, String password) {
        return null;
    }

    @Timed
    @Log
    @Override
    public boolean signOut(String token) {
//        return RedisUtil.(token) == 1;
        return false;
    }

//    private String genAndSaveToken(UserAccount userAccount) {
//        User user = new User();
//        user.setUserId(userAccount.getId());
//        user.setUserName(userAccount.getUserName());
//        user.setChannel(ChannelUtil.getChannel());
//        String token = TokenGenerator.gen();
////        CacheUtil.setObject(token, user);
//        return token;
//    }
//
//    private void addUserInfo(Long userId, String userName) {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(userId);
//        if (ValidationUtil.matchPhoneNo(userName)) {
//            userInfo.setPhone(userName);
//        } else if (ValidationUtil.matchEmail(userName)) {
//            userInfo.setEmail(userName);
//        }
//        userInfoHelper.insert(userInfo);
//    }
}
