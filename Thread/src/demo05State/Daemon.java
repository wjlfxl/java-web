package demo05State;

//守护线程
//线程分为用户线程和守护线程
//虚拟机必须确保用户线程执行完毕I
//虚拟机不用等待守护线程执行完毕
//如，后台记录操作日志，监控内存，垃圾回收等待

public class Daemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();

        Thread thread= new Thread(god);//将god设置为了守护线程
        thread.setDaemon(true);//默认用户线程是false。正常线程是用户线程
        thread.start();//上帝线程启动

        new Thread(you).start();//you启动了
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("我一直都在");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一直开心的活着");
        }

        System.out.println("再见---world！");
    }
}


