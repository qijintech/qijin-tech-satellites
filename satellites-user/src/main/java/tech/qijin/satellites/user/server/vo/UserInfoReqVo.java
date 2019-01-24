package tech.qijin.satellites.user.server.vo;

import lombok.Data;

import javax.annotation.Nullable;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserInfoReqVo {
    @Nullable
    private String nickname;
    @Nullable
    private String avatar;
    @Nullable
    private Byte sex;
    @Nullable
    private String email;
    @Nullable
    private String iphone;
    @Nullable
    private String address;
    @Nullable
    private String birthday;
    @Nullable
    private String slogan;
}
