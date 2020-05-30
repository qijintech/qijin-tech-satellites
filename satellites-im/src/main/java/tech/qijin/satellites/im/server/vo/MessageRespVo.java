package tech.qijin.satellites.im.server.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MessageRespVo {
    private List<MessageVo> messages;
    private UserVo user;
    private UserVo peer;
}
