package demo05State;

import java.util.Arrays;

//测试join
//想象为插队
//少使用，会让线程zuse
public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin join=new ThreadJoin();
        Thread thread=new Thread(join);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i==200){
                thread.join();//插队
            }
            System.out.println("main" + i);
        }

    }
}
