package tech.qijin.satellites.user.auth.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tech.qijin.satellites.user.annotation.FreeAccess;
import tech.qijin.satellites.user.auth.UserUtil;
import tech.qijin.satellites.user.auth.pojo.User;
import tech.qijin.util4j.cache.redis.RedisUtil;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.web.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String GROUP_ID = "tech.qijin";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();

        if (method.getAnnotation(FreeAccess.class) != null) {
            return true;
        }

        //如果不是self defined的方法，也无需进行权限校验。如spring自带的/error
        String className = method.getDeclaringClass().getCanonicalName();
        if (!className.startsWith(GROUP_ID)) {
            return true;
        }

        Optional<String> tokenOpt = ServletUtil.getHeader(request, "token");
        return tokenOpt.map(token -> {
            User user = (User) RedisUtil.getObject(token);
            MAssert.isTrue(user != null, ResEnum.UNAUTHORIZED);
            UserUtil.setUser(user);
            return true;
        }).orElse(false);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("UserAuthInterceptor  postHandle ...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("UserAuthInterceptor  afterCompletion ...");
        UserUtil.remove();
    }
}
