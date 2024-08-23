package demo02;
//龟兔赛跑的例子
/**
 * 1.实现Runnable接口
 * 2.实现run（）
 * 3.执行线程需要丢入runnable接口实现类
 * 4.调用start方法。
 */
public class ThreadTest5 implements Runnable {
    private static String winner;

    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag=gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--跑了"+i+"米");
        }
    }

    public boolean gameOver(int steps){
        if (winner!=null){
            return true;
        }if (steps>=100){
            winner=Thread.currentThread().getName();
            System.out.println("胜利者是"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类
        ThreadTest5 threadTest5=new ThreadTest5();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        //        调用start方法开启进程对象
        new Thread(threadTest5,"乌龟").start();
        new Thread(threadTest5,"兔子").start();

    }

}
