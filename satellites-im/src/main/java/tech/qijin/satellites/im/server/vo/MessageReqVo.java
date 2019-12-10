package tech.qijin.satellites.im.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tech.qijin.cell.im.base.MsgType;

/**
 * @author michealyang
 * @date 2019-11-15
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Data
@ApiModel(description = "发送消息请求体")
public class MessageReqVo {
    @ApiModelProperty(value = "12345", notes = "会话id，数字类型")
    private Long conversationId;
    @ApiModelProperty(value = "12345", notes = "对方uid，数字类型")
    private Long toUid;
    @ApiModelProperty(value = "TEXT", notes = "消息类型，文本类型")
    private MsgType msgType;
    @ApiModelProperty(value = "TEXT", notes = "消息内容，对应消息类型的json字符串")
    private String content;
}
