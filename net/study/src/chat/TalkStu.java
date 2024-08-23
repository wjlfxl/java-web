package chat;

public class TalkStu {
    public static void main(String[] args) {
        //topot代表发送到xxxx端口号
        new Thread(new TalkSend(    1234, "localhost", 9999)).start();
        //port代表该接收器端口号是8888，接收的包为老师传输的包
        new Thread(new TalkReceive(8888, "老师")).start();

    }
}
