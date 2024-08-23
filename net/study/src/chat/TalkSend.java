package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;//我自己的IP
    private String toIP;//对方的地址
    private int toPort;//对方的端口号

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            //准备数据作为参数传进datagramPacket，所以要从控制台进行读取System.in
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while(true){

            try {
                String  data = reader.readLine();
                byte[] datas = data.getBytes();
                //数据要以byte[]的形式传入
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
                //发送数据包
                socket.send(packet);

                if(data.equals("bye")){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //关闭资源
        socket.close();
    }
}
