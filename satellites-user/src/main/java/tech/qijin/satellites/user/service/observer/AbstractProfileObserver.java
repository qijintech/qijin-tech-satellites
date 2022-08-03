package tech.qijin.satellites.user.service.observer;

import org.springframework.beans.factory.annotation.Autowired;
import tech.qijin.satellites.user.service.observer.event.ProfileEvent;
import tech.qijin.util4j.lang.observer.AbstractObserver;

import javax.annotation.PostConstruct;

@Deprecated
public abstract class AbstractProfileObserver extends AbstractObserver<ProfileEvent> {
    @Autowired
    private ProfileObservable observable;

    @PostConstruct
    public void init() {
        observable.addObserver(this);
    }
}
