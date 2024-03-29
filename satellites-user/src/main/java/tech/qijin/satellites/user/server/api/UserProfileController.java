package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.satellites.user.server.vo.*;
import tech.qijin.satellites.user.server.vo.UserProfileResVo;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.bo.UserProfileBo;
import tech.qijin.sdk.tencent.base.TxAuditScene;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.ValidationUtil;
import tech.qijin.util4j.web.pojo.ResultVo;
import tech.qijin.util4j.web.util.UserUtil;

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

    @GetMapping("/basic")
    public BasicProfileVo basicProfile() {
        return BasicProfileVo.from(userProfileService.getUserProfile());
    }

    @PostMapping("/mini/update")
    public ResultVo updateProfileForMini(@RequestBody UserProfileReqVo profileReqVo) {
        UserProfileBo profile = ConvertUtil.convert(profileReqVo, UserProfileBo.class);
        userProfileService.updateForMini(profile);
        return ResultVo.instance().success();
    }

    @PostMapping("/update")
    public Boolean updateInfo(@RequestBody UserUpdateReqVo userUpdateReqVo) {
        ValidationUtil.validate(userUpdateReqVo);
        checkProfileInfo(userUpdateReqVo);
        UserProfile profile = ConvertUtil.convert(userUpdateReqVo, UserProfile.class);
        return userProfileService.update(profile);
    }

    @GetMapping("/info")
    public UserProfileResVo getProfile() {
        UserProfile profile = userProfileService.getUserProfile();
        return UserProfileResVo.from(profile);
    }

    private void checkProfileInfo(UserUpdateReqVo userUpdateReqVo) {
        if (StringUtils.isNotBlank(userUpdateReqVo.getName())) {
            MAssert.isTrue(userUpdateReqVo.getName().length() < 10, ResEnum.INVALID_PARAM.code, "姓名长度不能超过10个字符");
        }
    }
}
