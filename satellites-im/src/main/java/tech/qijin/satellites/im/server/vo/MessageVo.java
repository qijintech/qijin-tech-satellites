package tech.qijin.satellites.im.server.vo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.im.base.AbstractContent;
import tech.qijin.cell.im.base.MessageReadStatus;
import tech.qijin.cell.im.base.MsgType;

import java.util.Date;

@Data
@Builder
public class MessageVo {
    private Long msgId;
    private MsgType msgType;
    private Long fromUid;
    private Long toUid;
    private AbstractContent content;
    private String extra;
    private MessageReadStatus readStatus;
    private Date updateTime;
    private Date createTime;
}
