package tech.qijin.satellites.user.server.vo;

import lombok.Data;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.base.MaritalStatus;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.DateUtil;

import java.util.Date;

/**
 * @author michealyang
 * @date 2019/1/22
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserProfileResVo {

    private Long userId;

    private String name;

    private String avatar;

    private Gender gender;

    private String mobile;

    private String wechat;

    private Long birthdayNum;
    private String birthdayDay;
    private String birthdayMonth;
    private String birthdayYear;

    private String bornCity;

    private String liveCity;

    private String edu;

    private String eduDegree;

    private String job;

    private String height;

    private String weight;

    private MaritalStatus maritalStatus;

    public static UserProfileResVo from(UserProfile profile) {
        UserProfileResVo profileResVo = ConvertUtil.convert(profile, UserProfileResVo.class);
        if (profileResVo != null) {
            // 屏蔽手机号和微信号
            profileResVo.setMobile("");
            profileResVo.setWechat("");
            if (profile.getBirthday() != null) {
                profileResVo.setBirthdayNum(profile.getBirthday().getTime() / 1000);
                profileResVo.setBirthdayDay(DateUtil.formatStr(profile.getBirthday(), "yyyy-MM-dd"));
                profileResVo.setBirthdayMonth(DateUtil.formatStr(profile.getBirthday(), "yyyy-MM"));
                profileResVo.setBirthdayYear(DateUtil.formatStr(profile.getBirthday(), "yyyy"));
            }

        }
        return profileResVo;
    }
}
