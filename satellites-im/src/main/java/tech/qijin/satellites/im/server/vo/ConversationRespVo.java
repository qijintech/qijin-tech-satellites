package tech.qijin.satellites.im.server.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConversationRespVo {
    private List<ConversationDataVo> conversations;
    private Integer unreadTotal;
}
