package tech.qijin.satellites.user.service.bo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.user.db.model.UserImage;
import tech.qijin.cell.user.db.model.UserProfile;

import java.util.List;

@Data
@Builder
public class UserProfileAndImageBo {
    private UserProfile profile;
    private List<UserImage> images;
}
