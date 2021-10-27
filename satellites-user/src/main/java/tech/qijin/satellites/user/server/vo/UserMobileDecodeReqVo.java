package tech.qijin.satellites.user.server.vo;

import lombok.Data;

/**
 * 微信小程序获取手机号
 */
@Data
public class UserMobileDecodeReqVo {
    private String encryptedData;
    private String iv;
}
