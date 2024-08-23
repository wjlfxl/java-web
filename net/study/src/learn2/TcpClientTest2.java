package learn2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class TcpClientTest2 {
    public static void main(String[] args) throws IOException {
        //创建一个socket连接
//        Socket socket = new Socket(InetAddress.getByName("127.0.0.1",9999));
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);

        //创建一个输出流
        OutputStream outputStream = socket.getOutputStream();

        //读取文件
        FileInputStream fileInputStream = new FileInputStream("");
        //写文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        //确认接受完毕。才能断开
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos.toString());

        baos.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}
