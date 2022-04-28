package tech.qijin.satellites.user.base;

import tech.qijin.util4j.lang.template.ICacheKey;

public enum CacheKey implements ICacheKey {
    INSTANCE;

    private static final String MODULE = "user";

    @Override
    public String module() {
        return MODULE;
    }


    public String userTokenKey(Long userId) {
        return key("token", String.valueOf(userId));
    }
}