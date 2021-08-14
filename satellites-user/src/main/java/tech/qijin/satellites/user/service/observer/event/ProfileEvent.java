package tech.qijin.satellites.user.service.observer.event;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.user.db.model.UserImage;
import tech.qijin.cell.user.db.model.UserProfile;

import java.util.List;

@Data
@Builder
public class ProfileEvent {
    private Long userId;
    private ProfileEventType eventType;
    private UserProfile profile;
    private List<UserImage> images;
    private boolean isGenderChanged;
}
