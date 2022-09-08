package com.blog.aop;

import com.blog.Domain.User;
import com.blog.controller.utils.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//对表现层方法进行登录验证并返回账号id,用户只能看到自己的文章
@Aspect
@Component
public class loginStatusAop {

    private static Logger logger = LoggerFactory.getLogger(loginStatusAop.class);

    @Pointcut("execution(* com.blog.controller.BlogController.*(..)) || execution(* com.blog.controller.UserController.Delete(..))")
    public void verify(){}

    //这个厉害了,面向切面编程,获取coller的入参,修改入参属性然后再返回给coller
    //所有钩住的coller方法前端header要带上token参数
    @Around("verify()")
    public Object doverify(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token =attributes.getRequest().getHeader("token");
        Object[] args = joinPoint.getArgs();
        if(token!=null){
            JwtUtil.checkSign(token);
        }else {
            throw new RuntimeException("无token");
        }
        String userid=JwtUtil.getUserId(token);
        for (Object arg:args){
            if(arg instanceof User){
                User user= (User)arg;
                user.setId(Integer.valueOf(userid));
            }
        }
        return joinPoint.proceed(args);
    }
}
