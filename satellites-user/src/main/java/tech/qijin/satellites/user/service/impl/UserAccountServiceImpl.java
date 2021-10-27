package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.cell.user.base.EmailRegisterVo;
import tech.qijin.cell.user.base.AccountType;
import tech.qijin.cell.user.base.UserSessionBo;
import tech.qijin.cell.user.base.WechatRegisterVo;
import tech.qijin.cell.user.service.CellUserAccountService;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.util4j.aop.annotation.Log;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;

import javax.validation.constraints.NotNull;


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
    public String signUp(String username, String password, Boolean signIn) {
        EmailRegisterVo emailRegisterVo = new EmailRegisterVo();
        emailRegisterVo.setEmail(username);
        emailRegisterVo.setPassword(password);
        UserSessionBo userSessionBo = cellUserAccountService.register(AccountType.EMAIL, emailRegisterVo, signIn, 3);
        if (signIn) {
            return userSessionBo.getUserToken().getToken();
        }
        return "";
    }

    @Timed
    @Log
    @Override
    public UserBo signIn(String usename, String password) {
        return null;
    }

    @Override
    public UserBo signInForMini(String code) {
        WechatRegisterVo wechatRegisterVo = new WechatRegisterVo(code);
        UserSessionBo userSessionBo = cellUserAccountService.login(AccountType.MINI_WECHAT,
                wechatRegisterVo, 0);
        MAssert.notNull(userSessionBo, ResEnum.BAD_GATEWAY);
        return UserBo.builder()
                .token(userSessionBo.getUserToken().getToken())
                .loginStatus(userSessionBo.getLoginStatus())
                .build();
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


    @Override
    public String decodePhoneNumber(String encryptedData, String iv) {
        return cellUserAccountService.decodePhoneNumber(UserUtil.getUserId(), encryptedData, iv);
    }
}
