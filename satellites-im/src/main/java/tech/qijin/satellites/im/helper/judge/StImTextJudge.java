package tech.qijin.satellites.im.helper.judge;

import org.springframework.stereotype.Service;
import tech.qijin.cell.im.base.MessageSendBo;
import tech.qijin.cell.im.base.MsgType;
import tech.qijin.satellites.im.server.vo.MessageSendReqVo;

/**
 * 判断是否有敏感词
 */
@Service
public class StImTextJudge implements IJudge {
    @Override
    public Judgement doJudge(Long uid, MessageSendReqVo messageSendReqVo) {
        if (messageSendReqVo.getMsgType() != MsgType.TEXT) {
            return Judgement.defaultJudgement();
        }
        // TODO
        return Judgement.defaultJudgement();
    }
}
