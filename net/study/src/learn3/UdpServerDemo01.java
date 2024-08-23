package learn3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9000);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);//阻塞接收

        System.out.println(packet.getAddress().getHostAddress());//输出地址
        System.out.println(new String(packet.getData(),0,packet.getLength()));//输出传输内容

        //关闭资源
        socket.close();
    }

}
