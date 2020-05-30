package tech.qijin.satellites.im.helper.judge;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.im.base.MessageSendBo;
import tech.qijin.satellites.im.server.vo.MessageSendReqVo;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StJudgeChain {
    private List<IJudge> judges = Lists.newArrayList();

    @Autowired
    private StImUserJudge stImUserJudge;
    @Autowired
    private StImTextJudge stImTextJudge;
    @Autowired
    private StImImageJudge stImImageJudge;

    @PostConstruct
    public void init() {
        judges.add(stImUserJudge);
        judges.add(stImTextJudge);
        judges.add(stImImageJudge);
    }

    public Judgement doJudge(Long uid, MessageSendReqVo messageSendReqVo) {
        for (IJudge judge : judges) {
            Judgement judgement = judge.doJudge(uid, messageSendReqVo);
            if (judgement.getType() != Judgement.JudgementType.PASS) {
                return judgement;
            }
        }
        return Judgement.defaultJudgement();
    }
}
