package tech.qijin.satellites.user.service;

import java.util.Observer;

public interface UserObserverService {
    void addProfileObserver(Observer observer);

    void addImageObserver(Observer observer);

    void addProfileAndImageObserver(Observer observer);

    void profileNotify(long userId);

    void imageNotify(long userId);

    void profileAndImageNotify(long userId);
}
