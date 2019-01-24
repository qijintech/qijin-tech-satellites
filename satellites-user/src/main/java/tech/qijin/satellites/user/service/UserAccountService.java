package tech.qijin.satellites.user.service;

import tech.qijin.satellites.user.service.bo.UserBo;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface UserAccountService {
    /**
     * 注册
     *
     * @param userName
     * @param password
     * @param signIn   注册成功后是否直接登录，true: 登录; false: 不登录
     * @return
     */
    Optional<String> signUp(@NotNull String userName,
                            @NotNull String password,
                            @Nullable Boolean signIn);

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    UserBo signIn(@NotNull String userName,
                  @NotNull String password);

    /**
     * 退出
     */
    boolean signOut(@NotNull String token);

}
