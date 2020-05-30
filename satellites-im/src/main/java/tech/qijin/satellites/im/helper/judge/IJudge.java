package tech.qijin.satellites.im.helper.judge;

import tech.qijin.satellites.im.server.vo.MessageSendReqVo;

public interface IJudge {
    Judgement doJudge(Long uid, MessageSendReqVo messageSendReqVo);
}
