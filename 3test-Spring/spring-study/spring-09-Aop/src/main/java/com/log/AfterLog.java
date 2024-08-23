package com.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {

    //o(returnValue)返回值
    //method:要执行的目标对象的方法
    //objects:参数
    //o1(target):目标对象
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回结果为"+o);
    }
}
