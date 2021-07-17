package tech.qijin.satellites.user.service.bo;

import lombok.Data;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserProfileBo {
    @Nullable
    private String name;
    @Nullable
    private String avatar;
    @Nullable
    private Integer gender;
    @Nullable
    private String email;
    @Nullable
    private String mobile;
    @Nullable
    private String address;
    @Nullable
    private Date birthday;
    @Nullable
    private String slogan;
}
