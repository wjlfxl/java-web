package com.Diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.service.UserServiceImpl.*(..))")
    public void Before(){
        System.out.println("方法前================");
    }

    @After("execution(* com.service.UserServiceImpl.*(..))")
    public void After(){
        System.out.println("方法后===============");
    }


    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点;(少用)
    @Around("execution(* com.service.UserServiceImpl.*(..))")
    public void Around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

//        执行方法
        Object proceed=jp.proceed();

        System.out.println("环绕后");
    }
}
