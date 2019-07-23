package tech.qijin.satellites.address.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.rank.service.RankService;
import tech.qijin.util4j.web.annotation.ChannelRequired;
import tech.qijin.util4j.web.pojo.ResultVo;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@Slf4j
@RequestMapping("/rank")
public class AddressController {

    @Autowired
    private RankService rankService;

}
