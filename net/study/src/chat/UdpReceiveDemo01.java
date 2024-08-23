package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while(true) {

            //准备包接收
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);

            //断开连接
            byte[] data = packet.getData();
            //trim不用的话会打印出很多方格
            String receivedatas = new String(data, 0, data.length).trim();
            System.out.println(receivedatas);

            if (receivedatas.equals("bye")) {
                break;//当传入的数据是bye的时候就会断开连接
            }

        }

        socket.close();//关闭资源
    }

}
