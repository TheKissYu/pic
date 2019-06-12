package com.yuhaoze.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.err.println("uri"+uri);
        if (uri.equals("/pic/")){
           response.sendRedirect("/pic/Client/html/indexDemo.html");

        }else{
            filterChain.doFilter(request, response);
        }
//        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
