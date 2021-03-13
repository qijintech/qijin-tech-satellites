package tech.qijin.satellites.user.server.vo;

import lombok.Data;
import tech.qijin.util4j.web.validation.annotation.Mobile;

@Data
public class UserMobileReqVo {
    @Mobile
    private String mobile;
    private String captcha;
}
