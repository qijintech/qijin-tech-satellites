package tech.qijin.satellites.im.service;

import tech.qijin.cell.im.base.MessageSendBo;
import tech.qijin.satellites.im.server.vo.MessageSendReqVo;
import tech.qijin.satellites.im.service.bo.MessageBo;

import java.util.List;

public interface StMessageService {
    Long sendMessage(Long uid, MessageSendReqVo messageSendReqVo);

    List<MessageBo> listMessageHistory(Long uid, Long peerUid, Long msgId, Integer count);

    List<MessageBo> listMessageNew(Long uid, Long peerUid, Long msgId, Integer count);

    boolean readMessage(Long uid, Long peerUid, Long msgId);
}
