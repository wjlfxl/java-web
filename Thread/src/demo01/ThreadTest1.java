package demo01;

//创建多线程的方式一
/**
 * 1.开启主线程，继承Thread
 * 2.重写run（）
 * 3.调用start（）
 */
public class ThreadTest1 extends Thread {
    public static void main(String[] args) {
        //主线程

        //创建一个线程对象
        ThreadTest1 threadTest1=new ThreadTest1();

//        调用start方法开启进程对象
        threadTest1.start();


        for (int i = 0; i < 200; i++) {
            System.out.println("main-------"+i);
        }
    }

    @Override
    public void run() {
//        super.run();
        //run方法线程
        for (int i = 0; i < 20; i++) {
            System.out.println("run-------"+i);
        }

    }

}
