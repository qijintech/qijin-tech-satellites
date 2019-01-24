package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.satellites.user.auth.pojo.User;
import tech.qijin.satellites.user.base.Source;
import tech.qijin.satellites.user.db.model.UserAccount;
import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;
import tech.qijin.satellites.user.service.helper.UserInfoHelper;
import tech.qijin.util4j.aop.annotation.Log;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.cache.redis.RedisUtil;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.TokenGenerator;
import tech.qijin.util4j.utils.ValidationUtil;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountHelper userAccountHelper;
    @Autowired
    private UserInfoHelper userInfoHelper;

    @Timed
    @Log
    @Transactional
    @Override
    public Optional<String> signUp(String userName, String password, Boolean signIn) {
        userAccountHelper.checkUserName(userName);
        userAccountHelper.checkPassword(password);
        String hashedPassword = userAccountHelper.encryptPassword(password);
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userName);
        userAccount.setPassword(hashedPassword);
        userAccountHelper.addAccount(userAccount, Source.SELF);
        addUserInfo(userAccount.getId(), userName);
        return (signIn != null && signIn)
                ? Optional.of(genAndSaveToken(userAccount))
                : Optional.empty();
    }

    @Timed
    @Log
    @Override
    public UserBo signIn(String userName, String password) {
        Optional<UserAccount> userAccountOpt = userAccountHelper.getUserAccountByUserName(userName);
        MAssert.isTrue(userAccountOpt.isPresent(), ResEnum.UNAUTHORIZED);
        MAssert.isTrue(BCrypt.checkpw(password, userAccountOpt.get().getPassword()), ResEnum.UNAUTHORIZED);
        Optional<UserInfo> userInfoOpt = userInfoHelper.getUserInfoByUserId(userAccountOpt.get().getId());
        MAssert.isTrue(userInfoOpt.isPresent(), ResEnum.BAD_GATEWAY);
        UserBo userBo = new UserBo();
        userBo.setToken(genAndSaveToken(userAccountOpt.get()));
        userBo.setUserInfo(userInfoOpt.get());
        return userBo;
    }

    @Timed
    @Log
    @Override
    public boolean signOut(String token) {
        return RedisUtil.del(token) == 1;
    }

    private String genAndSaveToken(UserAccount userAccount) {
        User user = new User();
        user.setUserId(userAccount.getId());
        user.setUserName(userAccount.getUserName());
        user.setChannel(ChannelUtil.getChannel());
        String token = TokenGenerator.gen();
        RedisUtil.setObject(token, user);
        return token;
    }

    private void addUserInfo(Long userId, String userName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        if (ValidationUtil.matchPhoneNo(userName)) {
            userInfo.setPhone(userName);
        } else if (ValidationUtil.matchEmail(userName)) {
            userInfo.setEmail(userName);
        }
        userInfoHelper.insert(userInfo);
    }
}
