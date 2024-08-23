package learn2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerTest1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream inputStream=null;
        ByteArrayOutputStream baos=null;

        //我得有一个地址
        serverSocket = new ServerSocket(9999);
        while (true) {
            //        等待客户端连接过来
            socket = serverSocket.accept();
            //读取客户端信息
            inputStream = socket.getInputStream();

            //        管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        }

//        baos.close();
//        inputStream.close();
//        socket.close();
//        serverSocket.close();


        //用缓冲区拼接字符串
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len=inputStream.read(buffer))!=-1){
//            String msg=new String(buffer,0,len);
//            System.out.println(msg);
//        }

    }
}
