package tech.qijin.satellites.user.service;

public interface UserMobileService {
    /**
     * 获取手机验证码
     *
     * @param mobile
     * @return
     */
    void captcha(String mobile);

    /**
     * 手机号验证码登录
     *
     * @param mobile
     * @param captcha
     * @return
     */
    String signIn(String mobile, String captcha);
}
