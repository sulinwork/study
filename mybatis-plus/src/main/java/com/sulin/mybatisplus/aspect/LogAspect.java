package com.sulin.mybatisplus.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.sulin.mybatisplus.aspect.Log)")
    public void point() {
    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable  {
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("URI:" + request.getRequestURI());
        System.out.println("method:" + request.getMethod());
        //获取入参
        System.out.println("param:"+request.getParameterMap());

        try {
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("result:"+proceed);
            return proceed;
        } catch (Exception e) {
            System.out.println("result:"+e.getMessage());
            throw e;
        }
    }
}
