package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据作为参数传进datagramPacket，所以要从控制台进行读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            //数据要以byte[]的形式传入
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
            //发送数据包
            socket.send(packet);

            //当发送bye时断开连接
            if(data.equals("bye")){
                break;
            }
        }

        //关闭资源
        socket.close();
    }

}
