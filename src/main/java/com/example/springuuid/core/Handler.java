package com.example.springuuid.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Component
public class Handler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = "";
        final HttpSession httpSession = request.getSession();
        if (traceId == null || traceId.isEmpty()) { // 여기 이상해!
            traceId = UUID.randomUUID().toString();
            httpSession.setAttribute("traceId", traceId);
        } else {
            httpSession.setAttribute("traceId", traceId);
        }

        log.debug("UUID: {}", traceId);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        request.getSession().setAttribute("traceId", ""); // 예외에서 터져서 나가면 셋팅이 안되기 떄문에 예외처리에서도 셋팅되게 함
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
