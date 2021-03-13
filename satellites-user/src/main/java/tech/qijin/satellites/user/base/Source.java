package tech.qijin.satellites.user.base;

import tech.qijin.util4j.lang.constant.EnumValue;

/**
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public enum Source implements EnumValue<String> {
    NULL("无效"),
    SELF("自建"),
    WECHAT("微信");

    Source(String desc) {
        this.desc = desc;
    }

    private String desc;

    @Override
    public String value() {
        return this.name();
    }

    @Override
    public String desc() {
        return desc;
    }
}
