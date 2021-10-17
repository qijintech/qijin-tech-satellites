package tech.qijin.satellites.user.server.vo;

import lombok.Data;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.base.MaritalStatus;

import java.util.Date;

@Data
public class UserProfileResVo {

    private Long userId;

    private String name;

    private String avatar;

    private Gender gender;

    private String mobile;

    private String wechat;

    private Date birthday;

    private String bornCity;

    private String liveCity;

    private String edu;

    private String eduDegree;

    private String job;

    private String height;

    private String weight;

    private MaritalStatus maritalStatus;
}
