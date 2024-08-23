package learn2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClientTest1 {
    public static void main(String[] args) throws IOException {
        //1要知道服务器地址、端口号
        InetAddress Ip = InetAddress.getByName("127.0.0.1");
        int port=9999;

        //创建一个socket连接
        Socket socket = new Socket(Ip,port);

        //发送信息 I/O流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好啊,加油加油".getBytes(StandardCharsets.UTF_8));

        outputStream.close();
        socket.close();
    }
}
