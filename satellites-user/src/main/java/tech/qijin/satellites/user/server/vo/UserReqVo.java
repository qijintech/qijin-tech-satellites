package tech.qijin.satellites.user.server.vo;

import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserReqVo {
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
    @Nullable
    private Boolean signIn;
}
