package tech.qijin.satellites.order.server.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author michealyang
 * @date 2019/1/29
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    //添加到购物车
    @PostMapping("/add")
    public Object addToCart() {
        return null;
    }

    //从购物车移除
    @PostMapping("/remove")
    public Object removeFromCart() {
        return null;
    }

    //展示购物车内容
    @GetMapping("/list")
    public List<Object> list() {
        return null;
    }
}
