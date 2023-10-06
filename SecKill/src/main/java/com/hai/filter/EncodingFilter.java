package com.hai.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter   init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
        servletResponse.setCharacterEncoding("UTF-8");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter   destroy");
    }
}
