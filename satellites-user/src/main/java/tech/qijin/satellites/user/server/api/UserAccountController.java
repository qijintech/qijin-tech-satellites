package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.satellites.user.annotation.FreeAccess;
import tech.qijin.satellites.user.server.vo.UserReqVo;
import tech.qijin.satellites.user.server.vo.UserResVo;
import tech.qijin.satellites.user.service.UserAccountService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.util4j.aop.annotation.LogAndTimed;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.ValidationUtil;
import tech.qijin.util4j.web.annotation.ChannelRequired;
import tech.qijin.util4j.web.pojo.ResultVo;
import tech.qijin.util4j.web.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
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
@RestController
@RequestMapping("/user/account")
@Slf4j
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @FreeAccess
    @ChannelRequired
    @PostMapping("/signup")
    public ResultVo signUp(@RequestBody UserReqVo userReqVo) {
        ValidationUtil.validate(userReqVo);
        Optional<String> tokenOpt = userAccountService.signUp(userReqVo.getUserName(),
                userReqVo.getPassword(),
                userReqVo.getSignIn());
        return tokenOpt.map(token -> ResultVo.instance().data(token))
                .orElse(ResultVo.instance().success());
    }
    
    @FreeAccess
    @ChannelRequired
    @PostMapping("/signin")
    public UserResVo signIn(@RequestBody UserReqVo userReqVo) {
        ValidationUtil.validate(userReqVo);
        UserBo userBo = userAccountService.signIn(userReqVo.getUserName(), userReqVo.getPassword());
        UserResVo userResVo = ConvertUtil.convert(userBo.getUserInfo(), UserResVo.class);
        userResVo.setToken(userBo.getToken());
        return userResVo;
    }

    @ChannelRequired
    @PostMapping("/signout")
    public ResultVo signOut(HttpServletRequest request) {
        Optional<String> token = ServletUtil.getHeader(request, "token");
        if (userAccountService.signOut(token.get())) {
            return ResultVo.instance().success();
        } else {
            return ResultVo.instance().fail(ResEnum.BAD_REQUEST);
        }
    }
}
