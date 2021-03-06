package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.cell.user.service.CellUserProfileService;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.bo.UserProfileBo;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.utils.ConvertUtil;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private CellUserProfileService userProfileService;

    @Timed
    @Override
    public Optional<UserBo> getUserProfile() {
//        Long userId = UserUtil.getUserId();
//        Optional<UserInfo> userInfoOpt = userInfoHelper.getUserInfoByUserId(userId);
//        return userInfoOpt.map(userInfo -> {
//            UserBo userBo = new UserBo();
//            userBo.setUserInfo(userInfoOpt.get());
//            return Optional.of(userBo);
//        }).orElse(Optional.empty());
        return null;
    }

    @Override
    public boolean update(UserProfile profile) {
        Long userId = UserUtil.getUserId();
        profile.setUserId(userId);
        return userProfileService.updateProfile(profile);
    }

    @Override
    public void updateForMini(UserProfileBo userProfileBo) {
        Long userId = UserUtil.getUserId();
        UserProfile userProfile = ConvertUtil.convert(userProfileBo, UserProfile.class);
        userProfile.setUserId(userId);
        if (userProfileBo.getGender() != null && userProfileBo.getGender() == 1) {
            userProfile.setGender(Gender.MALE);
        }
        if (userProfileBo.getGender() != null && userProfileBo.getGender() == 2) {
            userProfile.setGender(Gender.FEMALE);
        }

        userProfileService.updateProfile(userProfile);
    }
}
