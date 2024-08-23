package demo05State;

import java.util.Arrays;

//观察线程状态
public class Watch {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state);//new

        //观察状态后启动
        thread.start();
        state=thread.getState();
        System.out.println(state);//run

        while (state!=Thread.State.TERMINATED){//只要线程不停止就一直输出的状态
            Thread.sleep(100);
            state=thread.getState();//更新状态
            System.out.println(state);//输出状态
        }
    }
}
