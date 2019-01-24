package tech.qijin.satellites.user.service.helper;

import tech.qijin.satellites.user.db.model.UserInfo;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface UserInfoHelper {
    /**
     * 更新用户信息，根据user id
     *
     * @param userInfo
     */
    boolean updateInfoByUserId(UserInfo userInfo);

    /**
     * 更新用户信息，根据pk
     *
     * @param userInfo
     * @return
     */
    boolean updateInfoById(UserInfo userInfo);

    /**
     * 插入UserInfo
     *
     * @param userInfo
     * @return
     */
    boolean insert(UserInfo userInfo);

    /**
     * 根据user id查询
     *
     * @param userId
     * @return
     */
    Optional<UserInfo> getUserInfoByUserId(Long userId);
}
