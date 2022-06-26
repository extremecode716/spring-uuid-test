package com.example.springuuid.core;


import com.example.springuuid.vo.LogScopeBean;
import com.example.springuuid.vo.LogScopeInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class Handler implements HandlerInterceptor {

    private final LogScopeBean logScopeBean;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // httpSession 에 "logScopeInfo" 셋팅
        if (logScopeBean != null) {
            final HttpSession httpSession = request.getSession();
            final LogScopeInfo logScopeInfo = logScopeBean.getLogScopeInfo();
            httpSession.setAttribute("logScopeInfo", logScopeInfo);
            log.info("UUID:{}", logScopeInfo.getUUID());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
