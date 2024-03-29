package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.cell.user.base.*;
import tech.qijin.cell.user.service.CellUserAccountService;
import tech.qijin.satellites.user.base.CacheKey;
import tech.qijin.util4j.redis.RedisUtil;
import tech.qijin.util4j.web.util.UserUtil;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.util4j.aop.annotation.Log;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;


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
    @Autowired
    private RedisUtil redisUtil;

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
        onSigIn(userSessionBo.getUserAccount().getId(), userSessionBo.getUserToken());
        return UserBo.builder()
                .userId(userSessionBo.getUserAccount().getId())
                .token(userSessionBo.getUserToken().getToken())
                .loginStatus(userSessionBo.getLoginStatus())
                .build();
    }

    private void onSigIn(Long userId, UserToken token) {
        redisUtil.setString(CacheKey.INSTANCE.userTokenKey(userId), token.getToken(), token.getExpire());
    }

    @Timed
    @Log
    @Override
    public boolean signOut(String token) {
        return redisUtil.delete(CacheKey.INSTANCE.userTokenKey(UserUtil.getUserId()));
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
