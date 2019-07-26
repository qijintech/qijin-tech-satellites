package tech.qijin.satellites.user.service;

import java.util.Optional;

import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.service.bo.UserBo;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface UserInfoService {
    /**
     * 更新用户信息
     *
     * @param userInfo
     */
    boolean updateInfoByUserId(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @return
     */
    Optional<UserBo> getUserInfo();
}
