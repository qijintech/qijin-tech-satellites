package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.db.model.UserImage;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.cell.user.service.CellUserImageService;
import tech.qijin.cell.user.service.CellUserProfileService;
import tech.qijin.satellites.user.service.UserImageService;
import tech.qijin.satellites.user.service.observer.ProfileObservable;
import tech.qijin.satellites.user.service.observer.event.ProfileEvent;
import tech.qijin.satellites.user.service.observer.event.ProfileEventType;
import tech.qijin.util4j.web.util.UserUtil;

@Slf4j
@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private CellUserImageService cellUserImageService;
    @Autowired
    private CellUserProfileService cellUserProfileService;

    @Override
    public UserImage addImage(Long userId, String url) {
        UserImage firstImage = cellUserImageService.getFirstImage(userId);
        if (firstImage == null) {
            UserProfile profile = new UserProfile();
            profile.setUserId(UserUtil.getUserId());
            profile.setCover(url);
            cellUserProfileService.updateProfile(profile);
        }
        UserImage userImage = cellUserImageService.addImage(userId, url);
        eventPublisher.publishEvent(ProfileEvent.builder()
                .eventType(ProfileEventType.IMAGE)
                .images(cellUserImageService.listUserImage(userId))
                .userId(userId)
                .build());
        return userImage;
    }

    @Override
    public boolean replaceImage(Long userId, Long id, String url) {
        if (cellUserImageService.replaceImage(userId, id, url)) {
            UserImage firstImage = cellUserImageService.getFirstImage(userId);
            if (firstImage != null && firstImage.getId().equals(id)) {
                UserProfile profile = new UserProfile();
                profile.setUserId(userId);
                profile.setCover(url);
                return cellUserProfileService.updateProfile(profile);
            }
            return true;
        }
        return true;
    }

    @Override
    public boolean deleteImage(Long userId, Long id) {
        UserImage firstImage = cellUserImageService.getFirstImage(userId);
        boolean res = cellUserImageService.deleteImage(userId, id);
        if (firstImage != null && firstImage.getId().equals(id)) {
            firstImage = cellUserImageService.getFirstImage(userId);
            UserProfile profile = new UserProfile();
            profile.setUserId(UserUtil.getUserId());
            if (firstImage == null) {
                profile.setCover("");
            } else {
                profile.setCover(firstImage.getUrl());
            }
            cellUserProfileService.updateProfile(profile);
        }
        eventPublisher.publishEvent(ProfileEvent.builder()
                .eventType(ProfileEventType.IMAGE)
                .images(cellUserImageService.listUserImage(userId))
                .userId(userId)
                .build());
        return res;
    }
}
