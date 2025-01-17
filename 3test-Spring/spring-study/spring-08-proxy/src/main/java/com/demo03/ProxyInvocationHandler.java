package com.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//等我们会用这个类，自动生成代理类!
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类(固定代码，只需要修改rent)
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);

    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        add();
        //动态代理的本质，就是使用反射机制实现
        Object result=method.invoke(rent,args);

        return null;
    }

    public void add(){
        System.out.println("代理加的东西");
    }
}
