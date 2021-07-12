package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.satellites.user.server.vo.UserInfoReqVo;
import tech.qijin.satellites.user.server.vo.UserInfoResVo;
import tech.qijin.satellites.user.server.vo.UserProfileReqVo;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.bo.UserProfileBo;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.ValidationUtil;
import tech.qijin.util4j.web.pojo.ResultVo;

/**
 * 用户信息相关接口
 *
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@RequestMapping("/api/v1/user/profile")
@Slf4j
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/mini/update")
    public ResultVo updateProfileForMini(@RequestBody UserProfileReqVo profileReqVo) {
        UserProfileBo profile = ConvertUtil.convert(profileReqVo, UserProfileBo.class);
        userProfileService.updateForMini(profile);
        return ResultVo.instance().success();
    }

    @PostMapping("/update")
    public ResultVo updateInfo(@RequestBody UserInfoReqVo userInfoReqVo) {
        ValidationUtil.validate(userInfoReqVo);
//        UserInfo userInfo = ConvertUtil.convert(userInfoReqVo, UserInfo.class);
//        if (userInfoService.updateInfoByUserId(userInfo)) {
//            return ResultVo.instance().success();
//        } else {
//            return ResultVo.instance().fail(ResEnum.BAD_REQUEST);
//        }
        return null;
    }

    @GetMapping("/detail")
    public UserInfoResVo infoDetail() {
//        Optional<UserBo> userBoOpt = userInfoService.getUserInfo();
//        return userBoOpt.map(
//                userBo -> ConvertUtil.convert(userBoOpt.get().getUserInfo(), UserInfoResVo.class)
//        ).orElse(new UserInfoResVo());
        return null;
    }
}
