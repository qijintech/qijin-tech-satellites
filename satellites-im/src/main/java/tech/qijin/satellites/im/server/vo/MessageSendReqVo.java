package tech.qijin.satellites.im.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tech.qijin.cell.im.base.MsgType;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author michealyang
 * @date 2019-11-08
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Data
@ApiModel(value = "发送消息请求实体", description = "发送消息需要传的参数")
public class MessageSendReqVo {
    @NotNull(message = "接收者uid不能为空")
    @ApiModelProperty(value = "发送者的UID", example = "666666", required = true)
    private Long toUid;

    @NotNull(message = "消息类型不能为空")
    @ApiModelProperty(value = "消息类型", example = "TEXT", required = true)
    private MsgType msgType;

    @NotNull(message = "消息内容不能为空")
    @ApiModelProperty(value = "消息内容", example = "...", required = true)
    private Map<String, Object> content;

    // 扩展字段
    @ApiModelProperty(value = "扩展字段", example = "JSON字符串", required = true)
    private Map<String, Object> ext;
}
