package demo05State;

//模拟倒计时
public class ThreadSleep2 {

    public static void main(String[] args) throws InterruptedException {
        tenDown();
    }

    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}
