package demo05State;

//测试stop
//1.建议线程正常停止--->利用次数,不建议死循环。
//2.建议使用标志位--->设置一个标志位
//3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
public class ThreadStop implements Runnable{
    //设置标志位
    private boolean flag=true;

    //设置一个方法改变标志位
    public void Stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run----线程"+i++);
        }
    }

    public static void main(String[] args) {
        ThreadStop threadStop =new ThreadStop();
        new Thread(threadStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i==900){
                //调用stop方法改变标志位，让线程停止
                threadStop.Stop();
                System.out.println("Thread--stop");
            }
        }
    }
}
