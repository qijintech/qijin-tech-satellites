package tech.qijin.satellites.im.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.im.base.MessageSendBo;
import tech.qijin.cell.im.service.CellImMessageService;
import tech.qijin.cell.im.util.MessageUtil;
import tech.qijin.satellites.im.helper.judge.Judgement;
import tech.qijin.satellites.im.helper.judge.StJudgeChain;
import tech.qijin.satellites.im.server.vo.MessageSendReqVo;
import tech.qijin.satellites.im.service.StMessageService;
import tech.qijin.satellites.im.service.bo.MessageBo;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.MAssert;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StMessageServiceImpl implements StMessageService {
    @Autowired
    private CellImMessageService cellImMessageService;
    @Autowired
    private StJudgeChain stJudgeChain;

    @Override
    public Long sendMessage(Long uid, MessageSendReqVo messageSendReqVo) {
        Judgement judgement = stJudgeChain.doJudge(uid, messageSendReqVo);
        MessageSendBo messageSendBo = convert(uid, messageSendReqVo);
        messageSendBo.setUid(uid);
        switch (judgement.getType()) {
            case PASS:
                return cellImMessageService.sendMessage(messageSendBo).getMsgId();
            case SILENT:
                messageSendBo.setSilent(true);
                return cellImMessageService.sendMessage(messageSendBo).getMsgId();
            case FORBIDDEN:
                MAssert.isTrue(false, judgement.getBuzCode(), judgement.getMessage());
        }
        return 0L;
    }

    @Override
    public List<MessageBo> listMessageHistory(Long uid, Long peerUid, Long msgId, Integer count) {
        return cellImMessageService.listMessageHistory(uid, peerUid, msgId, count)
                .stream()
                .map(cellImMessageBo -> MessageBo.builder().cellImMessageBo(cellImMessageBo).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageBo> listMessageNew(Long uid, Long peerUid, Long msgId, Integer count) {
        return cellImMessageService.listMessageNew(uid, peerUid, msgId, count)
                .stream()
                .map(cellImMessageBo -> MessageBo.builder().cellImMessageBo(cellImMessageBo).build())
                .collect(Collectors.toList());
    }

    @Override
    public boolean readMessage(Long uid, Long peerUid, Long msgId) {
        return false;
    }

    private MessageSendBo convert(Long uid, MessageSendReqVo messageSendReqVo) {
        return MessageSendBo.builder()
                .uid(uid)
                .toUid(messageSendReqVo.getToUid())
                .msgType(messageSendReqVo.getMsgType())
                .content(MessageUtil.deserializeContent(messageSendReqVo.getMsgType(), JSON.toJSONString(messageSendReqVo.getContent())))
                .ext(messageSendReqVo.getExt())
                .build();
    }
}
