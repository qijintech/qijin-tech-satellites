package tech.qijin.satellites.uploader.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadBo {
    private String fileName;
    private String url;
}
