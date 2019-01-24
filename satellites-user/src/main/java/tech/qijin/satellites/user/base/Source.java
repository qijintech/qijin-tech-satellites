package tech.qijin.satellites.user.base;

import tech.qijin.util4j.lang.constant.EnumValue;

/**
 * @author michealyang
 * @date 2019/1/16
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public enum Source implements EnumValue {
    NULL(0, "无效"),
    SELF(1, "自建"),
    WECHAT(2, "微信");

    Source(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    @Override
    public int value() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }
}
