package demo06Synchronized;

import sun.security.util.math.ImmutableIntegerModuloP;

import java.nio.channels.NonReadableChannelException;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket=new BuyTicket();

        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"小红").start();
        new Thread(buyTicket,"黄牛").start();
    }
}

class BuyTicket implements Runnable{
    private static int ticketNums=10;
    boolean flag=true;

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                Buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void Buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums<=0){
            flag=false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}
