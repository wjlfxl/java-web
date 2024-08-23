package demo02;
//多个线程同时操作同一个对象
//买火车票的例子
/**
 * 1.实现Runnable接口
 * 2.实现run（）
 * 3.执行线程需要丢入runnable接口实现类
 * 4.调用start方法。
 */
//发现问题:多个线程操作同一个资源的情况下,线程不安全，数据紊乱。
public class ThreadTest4 implements Runnable {
    private int ticketNum=10;

    @Override
    public void run() {
        //run方法线程
        while (true){
            if (ticketNum<=0)
            {
                 break;
            }
            //模拟延迟
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName()拿到当前执行线程是名字
            System.out.println(Thread.currentThread().getName()+"--拿到了"+ticketNum--+"张票");
        }

    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类
        ThreadTest4 threadTest4=new ThreadTest4();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        //        调用start方法开启进程对象
        new Thread(threadTest4,"小名").start();
        new Thread(threadTest4,"黄牛").start();
        new Thread(threadTest4,"小红").start();

    }

}
