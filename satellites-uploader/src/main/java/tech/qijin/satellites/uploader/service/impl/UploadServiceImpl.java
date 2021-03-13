package tech.qijin.satellites.uploader.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.qijin.satellites.uploader.server.vo.UploadVo;
import tech.qijin.satellites.uploader.service.UploadService;
import tech.qijin.satellites.uploader.service.bo.FileType;
import tech.qijin.satellites.uploader.service.bo.UploadBo;
import tech.qijin.sdk.tencent.cloud.TxCosService;
import tech.qijin.sdk.tencent.cloud.base.COSScene;
import tech.qijin.sdk.tencent.cloud.pojo.CosUploadVo;
import tech.qijin.sdk.tencent.cloud.pojo.TxCosType;
import tech.qijin.util4j.utils.FileUtil;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private TxCosService txCosService;

    @Override
    public UploadBo upload(FileType fileType, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String prefixName = FileUtil.prefix(fileName);
        String suffixName = FileUtil.suffix(fileName);
        File newFile = new File(fileName);
        FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
        COSScene cosScene = null;
        switch (fileType) {
            case FILE:
                cosScene = COSScene.FILE;
                break;
            case IMG:
                cosScene = COSScene.IMG;
                break;
            case AUDIO:
                cosScene = COSScene.AUDIO;
                break;
            case VIDEO:
                cosScene = COSScene.VIDEO;
                break;
        }
        CosUploadVo cosUploadVo = txCosService.uploadFile(cosScene, newFile);
        return new UploadBo(fileName, cosUploadVo.getUrl());
    }
}
