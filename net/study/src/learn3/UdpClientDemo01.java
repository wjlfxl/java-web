package learn3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.创建一个Socket连接
        DatagramSocket socket = new DatagramSocket();
        //2.建个包
        String msg = "你好，服务器";

        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9000;
        //参数分别为：数据（要转换为字符数组），数据长度，要发送给谁（地址和端口号）
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3.发送包
        socket.send(packet);

        //4.关闭资源
        socket.close();
    }
}
