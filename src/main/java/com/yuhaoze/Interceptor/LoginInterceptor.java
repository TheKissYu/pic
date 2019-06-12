package com.yuhaoze.Interceptor;

import com.yuhaoze.entity.Login;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService ;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.err.println("url:"+httpServletRequest.getRequestURL());
        System.err.println("uri:"+httpServletRequest.getRequestURI());
       if(MyUtils.eqUid(httpServletRequest.getSession(),loginService)){
           return true;
       }

            httpServletResponse.sendRedirect("/pic/Client/html/login.html");
            return false;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
