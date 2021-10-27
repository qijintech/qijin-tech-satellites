package tech.qijin.satellites.rank.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.satellites.rank.service.RankService;

/**
 * @author michealyang
 * @date 2019/1/RankServiceI6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@Slf4j
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService rankService;

}
