package tech.qijin.satellites.user.service.helper.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.db.dao.UserInfoDao;
import tech.qijin.satellites.user.db.model.UserInfo;
import tech.qijin.satellites.user.db.model.UserInfoExample;
import tech.qijin.satellites.user.service.helper.UserInfoHelper;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserInfoHelperImpl implements UserInfoHelper {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean updateInfoByUserId(UserInfo userInfo) {
        MAssert.notNull(userInfo, ResEnum.INVALID_PARAM);
        UserInfoExample example = new UserInfoExample();
        example.or()
                .andUserIdEqualTo(UserUtil.getUserId())
                .andChannelEqualTo(ChannelUtil.getChannel());
        return userInfoDao.updateByExampleSelective(userInfo, example) == 1;
    }

    @Override
    public boolean updateInfoById(UserInfo userInfo) {
        MAssert.notNull(userInfo, ResEnum.INVALID_PARAM);
        return userInfoDao.updateByPrimaryKeySelective(userInfo) == 1;
    }

    @Override
    public boolean insert(UserInfo userInfo) {
        checkUserInfo(userInfo);
        return userInfoDao.insertSelective(userInfo) == 1;
    }

    @Override
    public Optional<UserInfo> getUserInfoByUserId(Long userId) {
        UserInfoExample example = new UserInfoExample();
        example.or().andUserIdEqualTo(userId);
        return userInfoDao.selectByExample(example).stream().findFirst();
    }

    private void checkUserInfo(UserInfo userInfo) {
        MAssert.notNull(userInfo, ResEnum.INVALID_PARAM);
        if (!NumberUtil.gtZero(userInfo.getUserId())) {
            userInfo.setUserId(UserUtil.getUserId());
        }
        MAssert.isTrue(NumberUtil.gtZero(userInfo.getUserId()), ResEnum.INVALID_PARAM);
        userInfo.setChannel(ChannelUtil.getChannel());
    }
}
