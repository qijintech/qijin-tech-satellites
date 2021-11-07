package tech.qijin.satellites.user.server.vo;

import lombok.Data;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.util4j.utils.ConvertUtil;

import java.util.Date;

@Data
public class BasicProfileVo {
    private Long userId;

    private String name;

    private String avatar;

    private Gender gender;

    private Date birthday;

    public static BasicProfileVo from(UserProfile profile) {
        return ConvertUtil.convert(profile, BasicProfileVo.class);
    }
}
