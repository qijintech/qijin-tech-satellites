package tech.qijin.satellites.user.server.vo;

import lombok.Data;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.base.MaritalStatus;

import javax.annotation.Nullable;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserUpdateReqVo {
    @Nullable
    private String name;
    @Nullable
    private String avatar;
    @Nullable
    private Gender gender;
    @Nullable
    private String email;
    @Nullable
    private String mobile;
    @Nullable
    private String birthday;
    @Nullable
    private String slogan;
    private String bornCity;
    private String liveCity;
    // 身高
    private Integer height;
    // 婚姻状况
    private MaritalStatus maritalStatus;
}
