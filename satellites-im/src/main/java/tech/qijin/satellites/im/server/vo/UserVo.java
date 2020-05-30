package tech.qijin.satellites.im.server.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVo {
    private Long uid;
    private String nickname;
    private String avatar;
}
