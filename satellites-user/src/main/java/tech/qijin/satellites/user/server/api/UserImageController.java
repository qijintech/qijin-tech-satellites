package tech.qijin.satellites.user.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.util4j.web.util.UserUtil;
import tech.qijin.satellites.user.server.vo.UserImageReqVo;
import tech.qijin.satellites.user.service.UserImageService;

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
    private UserImageService userImageService;

    @PostMapping("/add")
    public Long addImage(@RequestBody UserImageReqVo imageReqVo) {
        return userImageService.addImage(UserUtil.getUserId(), imageReqVo.getUrl()).getId();
    }

    @PostMapping("/replace")
    public Boolean replaceImage(@RequestBody UserImageReqVo imageReqVo) {
        return userImageService.replaceImage(UserUtil.getUserId(), imageReqVo.getId(), imageReqVo.getUrl());
    }

    @PostMapping("/delete")
    public Boolean deleteImage(@RequestBody UserImageReqVo imageReqVo) {
        return userImageService.deleteImage(UserUtil.getUserId(), imageReqVo.getId());
    }
}
