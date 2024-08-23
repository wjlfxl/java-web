package demo01;

//静态代理模式总结:
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//好处:
    //代理对象 可以做很多真实对象做不了的事情
    //真实对象专注做自己的事情

import java.util.Arrays;

public class StaticProxy {
    public static void main(String[] args) {
        You you=new You();
        new Thread(()-> System.out.println("I Love You")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//fact
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("have wife");
    }
}

//agency
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}