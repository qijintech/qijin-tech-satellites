package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.cell.user.service.CellUserImageService;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.server.vo.UserImageReqVo;
import tech.qijin.satellites.user.server.vo.UserInfoResVo;
import tech.qijin.satellites.user.server.vo.UserProfileReqVo;
import tech.qijin.satellites.user.server.vo.UserUpdateReqVo;
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
@RequestMapping("/api/v1/user/image")
@Slf4j
public class UserImageController {
    @Autowired
    private CellUserImageService cellUserImageService;

    @PostMapping("/add")
    public Long addImage(@RequestBody UserImageReqVo imageReqVo) {
        return cellUserImageService.addImage(UserUtil.getUserId(), imageReqVo.getUrl()).getId();
    }

    @PostMapping("/replace")
    public Boolean replaceImage(@RequestBody UserImageReqVo imageReqVo) {
        return cellUserImageService.replaceImage(UserUtil.getUserId(), imageReqVo.getId(), imageReqVo.getUrl());
    }

    @PostMapping("/delete")
    public Boolean deleteImage(@RequestBody UserImageReqVo imageReqVo) {
        return cellUserImageService.deleteImage(UserUtil.getUserId(), imageReqVo.getId());
    }
}
