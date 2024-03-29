package tech.qijin.satellites.uploader.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.qijin.satellites.uploader.server.vo.UploadVo;
import tech.qijin.satellites.uploader.service.UploadService;
import tech.qijin.satellites.uploader.service.bo.FileType;
import tech.qijin.satellites.uploader.service.bo.UploadBo;
import tech.qijin.util4j.utils.ConvertUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author michealyang
 * @date 2019-12-06
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@RequestMapping("/api/v1/base/upload")
public class UploaderController {
    @Autowired
    private UploadService uploadService;


    @PostMapping(value = "/image")
    public UploadVo imgUpdate(@RequestParam("file") MultipartFile file,
                              @RequestParam(value = "w", required = false) Integer w,
                              @RequestParam(value = "h", required = false) Integer h) throws IOException {
        UploadBo uploadBo = uploadService.upload(FileType.IMG, file, w, h);
        return ConvertUtil.convert(uploadBo, UploadVo.class);
    }

    @PostMapping(value = "/file")
    public UploadVo fileUpdate(@RequestParam("file") MultipartFile file,
                               @RequestParam(value = "w", required = false) Integer w,
                               @RequestParam(value = "h", required = false) Integer h) throws IOException {
        UploadBo uploadBo = uploadService.upload(FileType.FILE, file, w, h);
        return ConvertUtil.convert(uploadBo, UploadVo.class);
    }
}
