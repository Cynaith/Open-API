package com.ly.openapi.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: Cynaith
 **/
@Aspect
@Component
public class ApiServiceAop {
    @Pointcut("execution(public String com.ly.openapi.service.impl.ApiServiceImpl.getMessage(String))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Object[] params = joinPoint.getArgs();
        System.out.println("请求参数:"+Arrays.toString(params));
    }
}
