package tech.qijin.satellites.user.service;

import tech.qijin.cell.user.db.model.UserImage;

public interface UserImageService {
    UserImage addImage(Long userId, String url);

    /**
     * 替换图片
     * @param userId
     * @param id
     * @param url
     * @return
     */
    boolean replaceImage(Long userId, Long id, String url);

    boolean deleteImage(Long userId, Long id);
}
