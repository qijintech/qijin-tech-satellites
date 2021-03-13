package tech.qijin.satellites.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.user.base.AccountType;
import tech.qijin.cell.user.base.MobileRegisterVo;
import tech.qijin.cell.user.base.UserSessionBo;
import tech.qijin.cell.user.service.CellUserAccountService;
import tech.qijin.satellites.user.service.UserMobileService;

@Service
public class UserMobileServiceImpl implements UserMobileService {
    @Autowired
    private CellUserAccountService cellUserAccountService;
    @Override
    public void captcha(String mobile) {
        cellUserAccountService.sendCaptcha(mobile);
    }

    @Override
    public String signIn(String mobile, String captcha) {
        MobileRegisterVo mobileRegisterVo = new MobileRegisterVo();
        mobileRegisterVo.setMobile(mobile);
        mobileRegisterVo.setCaptcha(captcha);
        UserSessionBo userSessionBo = cellUserAccountService.login(AccountType.MOBILE, mobileRegisterVo, 30);
        return userSessionBo.getUserToken().getToken();
    }
}
