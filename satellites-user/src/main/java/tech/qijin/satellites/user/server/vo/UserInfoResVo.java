package tech.qijin.satellites.user.server.vo;

import lombok.Data;

/**
 * @author michealyang
 * @date 2019/1/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserInfoResVo {
    private String nickname;
    private String avatar;
    private Byte sex;
    private String email;
    private String iphone;
    private String address;
    private String birthday;
    private String slogan;
}
