package tech.qijin.satellites.order.server.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.order.server.vo.CustomerOrderDetailVo;
import tech.qijin.satellites.order.server.vo.CustomerOrderVo;
import tech.qijin.satellites.order.server.vo.OrderVo;

/**
 * @author michealyang
 * @date 2019/1/28
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@Slf4j
@RequestMapping("/order/customer")
public class CustomerOrderController {

    //订单列表
    @RequestMapping("/list")
    public List<CustomerOrderVo> list() {
        return null;
    }

    //订单详情
    @RequestMapping("/detail")
    public CustomerOrderDetailVo detail() {
        return null;
    }

    //下单
    @PostMapping("/ordering")
    public OrderVo ordering() {
        return null;
    }
}
