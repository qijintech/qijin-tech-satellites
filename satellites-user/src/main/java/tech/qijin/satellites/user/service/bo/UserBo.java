package tech.qijin.satellites.user.service.bo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.user.base.LoginStatus;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
@Builder
public class UserBo {
//    private UserInfo userInfo;
    private String token;
    private LoginStatus loginStatus;
}
