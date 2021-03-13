package tech.qijin.satellites.uploader.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadVo {
    private String fileName;
    private String url;
}
