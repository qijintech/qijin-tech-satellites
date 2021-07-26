package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.db.model.UserImage;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.cell.user.service.CellUserImageService;
import tech.qijin.cell.user.service.CellUserProfileService;
import tech.qijin.satellites.user.service.UserImageService;
import tech.qijin.satellites.user.service.UserObserverService;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.bo.UserProfileAndImageBo;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Slf4j
@Service
public class UserObserverServiceImpl implements UserObserverService {
    private Observable profileObservable = new Observable();
    private Observable imageObservable = new Observable();
    private Observable profileAndImageObservable = new Observable();
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserImageService userImageService;
    @Autowired
    private CellUserProfileService cellUserProfileService;
    @Autowired
    private CellUserImageService cellUserImageService;

    @Override
    public void addProfileObserver(Observer observer) {
        profileObservable.addObserver(observer);
    }

    @Override
    public void addImageObserver(Observer observer) {
        imageObservable.addObserver(observer);
    }

    @Override
    public void addProfileAndImageObserver(Observer observer) {
        profileAndImageObservable.addObserver(observer);
    }

    @Override
    public void profileNotify(long userId) {
        UserProfile profile = cellUserProfileService.getProfile(userId);
        profileObservable.notifyObservers(profile);
        profileAndImageNotify(userId, profile);
    }

    @Override
    public void imageNotify(long userId) {
        List<UserImage> images = cellUserImageService.listUserImage(userId);
        imageObservable.notifyObservers(images);
        profileAndImageNotify(userId, images);
    }

    @Override
    public void profileAndImageNotify(long userId) {
        UserProfile profile = cellUserProfileService.getProfile(userId);
        List<UserImage> images = cellUserImageService.listUserImage(userId);
        profileAndImageObservable.notifyObservers(UserProfileAndImageBo.builder()
                .profile(profile)
                .images(images)
                .build());

    }

    private void profileAndImageNotify(long userId, List<UserImage> images) {
        UserProfile profile = cellUserProfileService.getProfile(userId);
        profileAndImageObservable.notifyObservers(UserProfileAndImageBo.builder()
                .profile(profile)
                .images(images)
                .build());
    }

    private void profileAndImageNotify(long userId, UserProfile profile) {
        List<UserImage> images = cellUserImageService.listUserImage(userId);
        profileAndImageObservable.notifyObservers(UserProfileAndImageBo.builder()
                .profile(profile)
                .images(images)
                .build());
    }
}
