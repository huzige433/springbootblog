package com.blog.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常统一处理工具
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doExcption(Exception ex){
        ex.printStackTrace();
        return new R(false,null,ex.getMessage());
    }

}
