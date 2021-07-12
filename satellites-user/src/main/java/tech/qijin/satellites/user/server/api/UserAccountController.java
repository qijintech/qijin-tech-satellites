package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.user.annotation.FreeAccess;
import tech.qijin.satellites.user.server.vo.UserAccountReqVo;
import tech.qijin.satellites.user.server.vo.UserLoginReqVo;
import tech.qijin.satellites.user.server.vo.UserLoginResVo;
import tech.qijin.satellites.user.server.vo.UserResVo;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.ValidationUtil;
import tech.qijin.util4j.web.pojo.ResultVo;
import tech.qijin.util4j.web.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * 用户操作相关接口
 * <p>
 * <ul>
 * <li>登录</li>
 * <li>注册</li>
 * <li>注销</li>
 * </ul>
 * </p>
 *
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Validated
@RestController
@RequestMapping("/api/v1/user/account")
@Slf4j
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @FreeAccess
    @PostMapping("/login/mini")
    public UserLoginResVo loginMini(@RequestBody @NotNull UserLoginReqVo loginReqVo) {
        MAssert.notBlank(loginReqVo.getCode(), ResEnum.INVALID_PARAM);
        UserBo userBo = userAccountService.signInForMini(loginReqVo.getCode());
        return UserLoginResVo.builder()
                .token(userBo.getToken())
                .loginStatus(userBo.getLoginStatus())
                .build();
    }

    @FreeAccess
    @PostMapping("/signUp")
    public ResultVo signUp(@RequestBody UserAccountReqVo userAccountReqVo) {
        ValidationUtil.validate(userAccountReqVo);
        String token = userAccountService.signUp(userAccountReqVo.getUsername(),
                userAccountReqVo.getPassword(),
                userAccountReqVo.getSignIn());
        return ResultVo.instance().data(token);
    }
    
    @PostMapping("/signIn")
    public UserResVo signIn(@RequestBody UserAccountReqVo userAccountReqVo) {
        ValidationUtil.validate(userAccountReqVo);
        UserBo userBo = userAccountService.signIn(userAccountReqVo.getUsername(), userAccountReqVo.getPassword());
        UserResVo userResVo = null;
//        ConvertUtil.convert(userBo.getUserInfo(), UserResVo.class);
        userResVo.setToken(userBo.getToken());
        return userResVo;
    }

    @PostMapping("/signOut")
    public ResultVo signOut(HttpServletRequest request) {
        Optional<String> token = ServletUtil.getHeader(request, "token");
        if (userAccountService.signOut(token.get())) {
            return ResultVo.instance().success();
        } else {
            return ResultVo.instance().fail(ResEnum.BAD_REQUEST);
        }
    }
}
