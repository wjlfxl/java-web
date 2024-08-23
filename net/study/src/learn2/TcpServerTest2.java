package learn2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerTest2 {

    public static void main(String[] args) throws IOException {

        //创建一个服务
        ServerSocket serverSocket = new ServerSocket(9999);

        //监听客户端连接
        Socket socket = serverSocket.accept(); //阻塞式监听，会一直等连接
        //获取输入流
        InputStream inputStream = socket.getInputStream();

        //
        FileOutputStream fileOutputStream = new FileOutputStream("receive.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        //通知服务器接受完毕
        OutputStream outputStream =socket.getOutputStream();
        outputStream.write("接受完毕，可以断开了".getBytes(StandardCharsets.UTF_8));

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


        //用缓冲区拼接字符串
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len=inputStream.read(buffer))!=-1){
//            String msg=new String(buffer,0,len);
//            System.out.println(msg);
//        }

    }
}
