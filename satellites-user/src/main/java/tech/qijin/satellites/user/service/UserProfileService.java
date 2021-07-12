package tech.qijin.satellites.user.service;

import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.satellites.user.service.bo.UserProfileBo;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface UserProfileService {
    /**
     * 更新用户信息
     *
     * @param userInfo
     */
//    boolean updateInfoByUserId(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @return
     */
    Optional<UserBo> getUserProfile();

    void updateForMini(UserProfileBo userProfileBo);
}
