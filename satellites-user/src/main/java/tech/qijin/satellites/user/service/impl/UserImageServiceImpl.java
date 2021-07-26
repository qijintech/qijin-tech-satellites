package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.db.model.UserImage;
import tech.qijin.cell.user.service.CellUserImageService;
import tech.qijin.satellites.user.service.UserImageService;
import tech.qijin.satellites.user.service.UserObserverService;

import java.util.Observable;

@Slf4j
@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    private UserObserverService userObserverService;
    @Autowired
    private CellUserImageService cellUserImageService;

    @Override
    public UserImage addImage(Long userId, String url) {
        UserImage userImage = cellUserImageService.addImage(userId, url);
        userObserverService.imageNotify(userId);
        return userImage;
    }

    @Override
    public boolean replaceImage(Long userId, Long id, String url) {
        return cellUserImageService.replaceImage(userId, id, url);
    }

    @Override
    public boolean deleteImage(Long userId, Long id) {
        boolean res = cellUserImageService.deleteImage(userId, id);
        userObserverService.imageNotify(userId);
        return res;
    }
}
