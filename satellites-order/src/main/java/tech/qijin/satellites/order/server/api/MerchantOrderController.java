package tech.qijin.satellites.order.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.satellites.order.server.vo.MerchantOrderVo;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/28
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@Slf4j
@RequestMapping("/order/customer")
public class MerchantOrderController {
    @RequestMapping("/list")
    public List<MerchantOrderVo> list() {
        return null;
    }

    @RequestMapping("/detail")
    public Object detail() {
        return null;
    }
}
