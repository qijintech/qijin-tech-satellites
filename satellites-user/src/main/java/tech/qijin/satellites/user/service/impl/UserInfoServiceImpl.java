package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.service.UserInfoService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.helper.UserInfoHelper;
import tech.qijin.util4j.aop.annotation.Log;
import tech.qijin.util4j.aop.annotation.Timed;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoHelper userInfoHelper;

    @Timed
    @Log
    @Override
    public boolean updateInfoByUserId(UserInfo userInfo) {
        Long userId = UserUtil.getUserId();
        userInfo.setUserId(userId);
        return userInfoHelper.updateInfoByUserId(userInfo);
    }

    @Timed
    @Override
    public Optional<UserBo> getUserInfo() {
        Long userId = UserUtil.getUserId();
        Optional<UserInfo> userInfoOpt = userInfoHelper.getUserInfoByUserId(userId);
        return userInfoOpt.map(userInfo -> {
            UserBo userBo = new UserBo();
            userBo.setUserInfo(userInfoOpt.get());
            return Optional.of(userBo);
        }).orElse(Optional.empty());
    }
}
