package tech.qijin.satellites.user.service.observer;

import org.springframework.stereotype.Service;
import tech.qijin.satellites.user.service.observer.event.ProfileEvent;

import java.util.Observable;

@Service
public class ProfileObservable extends Observable {

    public void notifyEvent(ProfileEvent event) {
        setChanged();
        notifyObservers(event);
    }
}
