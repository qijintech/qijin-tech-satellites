package tech.qijin.satellites.im.server.vo;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel("会话结果")
public class ConversationDataVo {
    private UserVo userVo;
    private ConversationVo conversationVo;
}
