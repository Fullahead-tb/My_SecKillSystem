package com.hai.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        if (e instanceof LoginErrorException){
            //说明是一个登录异常
            String message = e.getMessage();
            ModelAndView mv = new ModelAndView();
            mv.addObject("message",message);
            mv.setViewName("error");
            return mv;
        }


        return null;
    }

//    @ResponseBody
//    public String responseJSON(String message){
//        return ""
//    }
}
