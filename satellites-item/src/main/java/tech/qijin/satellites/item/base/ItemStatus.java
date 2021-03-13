package tech.qijin.satellites.item.base;

import tech.qijin.util4j.lang.constant.EnumValue;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public enum ItemStatus implements EnumValue<Integer> {
    NULL(0, "无效"),
    ON_SHELF(1, "上架"),
    OFF_SHELF(2, "下架");

    ItemStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    @Override
    public Integer value() {
        return 0;
    }

    @Override
    public String desc() {
        return null;
    }
}
