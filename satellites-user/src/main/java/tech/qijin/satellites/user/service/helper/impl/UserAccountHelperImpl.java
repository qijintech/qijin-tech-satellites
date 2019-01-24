package tech.qijin.satellites.user.service.helper.impl;

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.user.base.Source;
import tech.qijin.satellites.user.db.dao.UserAccountDao;
import tech.qijin.satellites.user.db.model.UserAccount;
import tech.qijin.satellites.user.db.model.UserAccountExample;
import tech.qijin.satellites.user.service.helper.UserAccountHelper;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.ValidationUtil;

import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/21
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class UserAccountHelperImpl implements UserAccountHelper {
    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public void checkUserName(String userName) {
        MAssert.notBlank(userName, ResEnum.INVALID_PARAM);
        UserAccountExample example = new UserAccountExample();
        example.or()
                .andUserNameEqualTo(userName)
                .andChannelEqualTo(ChannelUtil.getChannel());
        MAssert.isTrue(userAccountDao.countByExample(example) == 0, ResEnum.DUPLICATE_USER);
    }

    @Override
    public void checkPassword(String password) {
        MAssert.notBlank(password, ResEnum.INVALID_PARAM);
    }

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(11));
    }

    @Override
    public void addAccount(UserAccount userAccount, Source source) {
        checkUserAccount(userAccount);
        MAssert.notNull(source, ResEnum.INVALID_PARAM);
        userAccount.setSource(source);
        userAccountDao.insertSelective(userAccount);
    }

    @Override
    public Optional<UserAccount> getUserAccountByUserName(String userName) {
        UserAccountExample example = new UserAccountExample();
        example.or()
                .andUserNameEqualTo(userName)
                .andChannelEqualTo(ChannelUtil.getChannel());
        return userAccountDao.selectByExample(example).stream().findFirst();
    }

    private void checkUserAccount(UserAccount userAccount) {
        MAssert.notNull(userAccount, ResEnum.INVALID_PARAM);
        MAssert.notBlank(userAccount.getUserName(), ResEnum.INVALID_PARAM);
        MAssert.notBlank(userAccount.getPassword(), ResEnum.INVALID_PARAM);
        userAccount.setChannel(ChannelUtil.getChannel());
    }
}
