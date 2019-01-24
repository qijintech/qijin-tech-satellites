package tech.qijin.satellites.user.service.helper;

import tech.qijin.satellites.user.base.Source;
import tech.qijin.satellites.user.db.model.UserAccount;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface UserAccountHelper {
    /**
     * 校验user name的合法性和唯一性
     *
     * @param userName
     */
    void checkUserName(String userName);

    /**
     * 校验密码的安全性
     *
     * @param password
     */
    void checkPassword(String password);

    /**
     * 加密密码
     * <p>使用BCrypt加密</p>
     *
     * @param password
     * @return
     */
    String encryptPassword(String password);

    /**
     * 添加新的用户
     *
     * @param userAccount
     */
    void addAccount(UserAccount userAccount, Source source);

    /**
     * 根据user name获取账号信息
     *
     * @param userName
     * @return
     */
    Optional<UserAccount> getUserAccountByUserName(String userName);
}
