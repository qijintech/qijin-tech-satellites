package tech.qijin.satellites.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.base.Config;
import tech.qijin.cell.user.base.Gender;
import tech.qijin.cell.user.db.model.UserProfile;
import tech.qijin.cell.user.service.CellUserAccountService;
import tech.qijin.cell.user.service.CellUserProfileService;
import tech.qijin.sdk.tencent.base.TxAuditScene;
import tech.qijin.sdk.tencent.mini.TxMiniAuditService;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.web.util.UserUtil;
import tech.qijin.satellites.user.service.UserProfileService;
import tech.qijin.satellites.user.service.bo.UserProfileBo;
import tech.qijin.satellites.user.service.observer.ProfileObservable;
import tech.qijin.satellites.user.service.observer.event.ProfileEvent;
import tech.qijin.satellites.user.service.observer.event.ProfileEventType;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.utils.ConvertUtil;

import java.util.regex.Pattern;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    private Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    @Autowired
    private CellUserProfileService userProfileService;
    @Autowired
    private TxMiniAuditService txMiniAuditService;
    @Autowired
    private CellUserAccountService cellUserAccountService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Timed
    @Override
    public UserProfile getUserProfile() {
        return userProfileService.getProfile(UserUtil.getUserId());
    }

    @Override
    public boolean update(UserProfile profile) {
        Long userId = UserUtil.getUserId();
        profile.setUserId(userId);
        checkContent(profile);
        boolean res = userProfileService.updateProfile(profile);
        eventPublisher.publishEvent(ProfileEvent.builder()
                .eventType(ProfileEventType.PROFILE)
                .profile(userProfileService.getProfile(userId))
                .userId(userId)
                .isGenderChanged(profile.getGender() != null)
                .build());
        return res;
    }

    @Override
    public void updateForMini(UserProfileBo userProfileBo) {
        Long userId = UserUtil.getUserId();
        UserProfile userProfile = ConvertUtil.convert(userProfileBo, UserProfile.class);
        userProfile.setUserId(userId);
        checkContent(userProfile);
        if (userProfileBo.getGender() != null && userProfileBo.getGender() == 1) {
            userProfile.setGender(Gender.MALE);
        }
        if (userProfileBo.getGender() != null && userProfileBo.getGender() == 2) {
            userProfile.setGender(Gender.FEMALE);
        }

        userProfileService.updateProfile(userProfile);
        eventPublisher.publishEvent(ProfileEvent.builder()
                .eventType(ProfileEventType.PROFILE)
                .profile(userProfileService.getProfile(userId))
                .userId(userId)
                .isGenderChanged(userProfileBo.getGender() != null)
                .build());
    }

    private void checkContent(UserProfile profile) {
        if (Config.whitelist.contains(profile.getUserId())) return;

        String openid = cellUserAccountService.getOpenid(profile.getUserId());
        if (StringUtils.isNotBlank(profile.getName())) {
            MAssert.isTrue(txMiniAuditService.checkMsg(openid, profile.getName(), TxAuditScene.PROFILE), ResEnum.RISK_CONTENT);
        }
        if (StringUtils.isNotBlank(profile.getBornCity())) {
            MAssert.isTrue(txMiniAuditService.checkMsg(openid, profile.getBornCity(), TxAuditScene.PROFILE), ResEnum.RISK_CONTENT);
        }
        if (StringUtils.isNotBlank(profile.getJob())) {
            MAssert.isTrue(txMiniAuditService.checkMsg(openid, profile.getJob(), TxAuditScene.PROFILE), ResEnum.RISK_CONTENT);
        }
        if (StringUtils.isNotBlank(profile.getLiveCity())) {
            MAssert.isTrue(txMiniAuditService.checkMsg(openid, profile.getLiveCity(), TxAuditScene.PROFILE), ResEnum.RISK_CONTENT);
        }
        if (StringUtils.isNotBlank(profile.getMobile())) {
            MAssert.isTrue(p.matcher(profile.getMobile()).matches(), ResEnum.INVALID_MOBILE);
        }
    }
}
