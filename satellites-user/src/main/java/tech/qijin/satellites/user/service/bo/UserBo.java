package tech.qijin.satellites.user.service.bo;

import lombok.Data;
import tech.qijin.satellites.user.db.model.UserInfo;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class UserBo {
    private UserInfo userInfo;
    private String token;
}
