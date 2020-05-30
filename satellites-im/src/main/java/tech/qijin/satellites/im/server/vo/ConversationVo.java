package tech.qijin.satellites.im.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversationVo {
    @ApiModelProperty("version id")
    private Long versionId;
    @ApiModelProperty("未读数")
    private Integer unreadCount;
    @ApiModelProperty("最后一条消息")
    private String lastMsg;
    @ApiModelProperty("最后一条消息时间")
    private String updateTime;
}
