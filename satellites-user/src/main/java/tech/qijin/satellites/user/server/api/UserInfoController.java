package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.server.vo.UserInfoReqVo;
import tech.qijin.satellites.user.server.vo.UserInfoResVo;
import tech.qijin.satellites.user.service.UserInfoService;
import tech.qijin.satellites.user.service.bo.UserBo;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.ValidationUtil;
import tech.qijin.util4j.web.annotation.ChannelRequired;
import tech.qijin.util4j.web.pojo.ResultVo;

import java.util.Optional;

/**
 * 用户信息相关接口
 *
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@RequestMapping("/user/info")
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @ChannelRequired
    @PostMapping("/update")
    public ResultVo updateInfo(@RequestBody UserInfoReqVo userInfoReqVo) {
        ValidationUtil.validate(userInfoReqVo);
        UserInfo userInfo = ConvertUtil.convert(userInfoReqVo, UserInfo.class);
        if (userInfoService.updateInfoByUserId(userInfo)) {
            return ResultVo.instance().success();
        } else {
            return ResultVo.instance().fail(ResEnum.BAD_REQUEST);
        }
    }

    @ChannelRequired
    @GetMapping("/detail")
    public UserInfoResVo infoDetail() {
        Optional<UserBo> userBoOpt = userInfoService.getUserInfo();
        return userBoOpt.map(
                userBo -> ConvertUtil.convert(userBoOpt.get().getUserInfo(), UserInfoResVo.class)
        ).orElse(new UserInfoResVo());
    }
}
