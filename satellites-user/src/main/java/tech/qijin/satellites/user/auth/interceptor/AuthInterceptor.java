package tech.qijin.satellites.user.auth.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tech.qijin.cell.user.service.CellUserTokenService;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;
import tech.qijin.util4j.utils.Util;
import tech.qijin.util4j.web.util.UserUtil;
import tech.qijin.util4j.web.pojo.User;
import tech.qijin.util4j.lang.annotation.FreeAccess;
import tech.qijin.util4j.web.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private CellUserTokenService cellUserTokenService;

    private static final String GROUP_ID = "tech.qijin";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("AuthInterceptor start");
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        Optional<String> tokenOpt = ServletUtil.getHeader(request, "token");

        if (method.getAnnotation(FreeAccess.class) != null) {
            if (tokenOpt.isPresent()) {
                Long userId = Util.runIgnoreEx(() -> cellUserTokenService.auth(tokenOpt.get()), 0L);
                User user = new User();
                user.setUserId(userId);
                UserUtil.setUser(user);
                return true;
            }
            return true;
        }

        //如果不是self defined的方法，也无需进行权限校验。如spring自带的/error
        String className = method.getDeclaringClass().getCanonicalName();
        if (!className.startsWith(GROUP_ID)) {
            return true;
        }

        if (tokenOpt.isPresent()) {
            Long userId = cellUserTokenService.auth(tokenOpt.get());
            MAssert.isTrue(NumberUtil.gtZero(userId), ResEnum.UNAUTHORIZED);
            User user = new User();
            user.setUserId(userId);
            UserUtil.setUser(user);
            return true;
        }
        return false;
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
