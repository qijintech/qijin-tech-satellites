package tech.qijin.satellites.user.server.vo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.user.base.LoginStatus;

@Data
@Builder
public class UserLoginResVo {
    private Long userId;
    private String token;
    private LoginStatus loginStatus;
}
