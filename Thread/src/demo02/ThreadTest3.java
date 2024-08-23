package demo02;

//创建多线程的方式二

/**
 * 1.实现Runnable接口
 * 2.实现run（）
 * 3.执行线程需要丢入runnable接口实现类
 * 4.调用start方法。
 */
public class ThreadTest3 implements Runnable {
    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i < 20; i++) {
            System.out.println("run-------"+i);
        }

    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类
        ThreadTest3 ThreadTest3=new ThreadTest3();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        Thread thread=new Thread(ThreadTest3);

//        调用start方法开启进程对象
        thread.start();


        for (int i = 0; i < 200; i++) {
            System.out.println("main-------"+i);
        }
    }

}
