package chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(4321,"localhost",8888)).start();
        //port代表该接收器端口号是9999，接收的包为学生传输的包
        new Thread(new TalkReceive(9999,"学生")).start();
    }

}
