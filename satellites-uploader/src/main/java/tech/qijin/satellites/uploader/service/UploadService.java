package tech.qijin.satellites.uploader.service;

import org.springframework.web.multipart.MultipartFile;
import tech.qijin.satellites.uploader.service.bo.FileType;
import tech.qijin.satellites.uploader.service.bo.UploadBo;

import java.io.IOException;

public interface UploadService {
    UploadBo upload(FileType fileType, MultipartFile file) throws IOException;
}
