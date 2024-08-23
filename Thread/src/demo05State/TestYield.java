package demo05State;

//测试礼让线程
//礼让不一定成功
public class TestYield {
    public static void main(String[] args) {
        MyYield yield=new MyYield();
        new Thread(yield,"a").start();
        new Thread(yield,"b").start();
    }
}


class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程结束");

    }
}