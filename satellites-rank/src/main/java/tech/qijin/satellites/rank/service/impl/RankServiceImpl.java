package tech.qijin.satellites.rank.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.rank.service.RankService;
import tech.qijin.satellites.rank.service.helper.RankHelper;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankHelper commentHelper;
}
