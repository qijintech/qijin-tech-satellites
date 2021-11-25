package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.user.server.vo.UserMobileReqVo;
import tech.qijin.satellites.user.service.UserMobileService;
import tech.qijin.util4j.lang.annotation.FreeAccess;

/**
 * 短信操作接口
 *
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Validated
@RestController
@RequestMapping("/api/v1/user/mobile")
@Slf4j
public class UserMobileController {
    @Autowired
    private UserMobileService userMobileService;

    @FreeAccess
    @GetMapping("/captcha")
    public void captcha(@Validated UserMobileReqVo userMobileReqVo) {
        userMobileService.captcha(userMobileReqVo.getMobile());
    }

    @FreeAccess
    @PostMapping("/signIn")
    public String signIn(@RequestBody UserMobileReqVo userMobileReqVo) {
        return userMobileService.signIn(userMobileReqVo.getMobile(), userMobileReqVo.getCaptcha());
    }
}
