package com.demo04;
import com.demo02.UserService;
import com.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {

       //真实角色
        UserServiceImpl userService=new UserServiceImpl();

        //代理角色，目前没有
        ProxyInvocationHandler pih=new ProxyInvocationHandler();

        //通过调用程序处理角色来处理我们要调用的接口对象!
        pih.setTarget(userService);

        //这里的proxy就是动态生成的，我们并没有写!
        UserService proxy=(UserService) pih.getProxy();

        proxy.add();
    }
}
