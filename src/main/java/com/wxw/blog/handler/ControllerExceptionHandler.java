package com.wxw.blog.handler;

import com.sun.javafx.scene.layout.region.RepeatStruct;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wxw
 * @data 2020/3/5 15 :54
 * @description
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request,Exception e) throws Exception {
        logger.error("Requset URL: {},Exception : {}",request.getRequestURI(),e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
                throw  e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURI());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;


    }
}
