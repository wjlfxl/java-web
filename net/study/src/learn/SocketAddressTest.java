package learn;

import java.net.InetSocketAddress;
import java.util.Arrays;

public class SocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println("socketAddress = " + socketAddress);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println("socketAddress2 = " + socketAddress2);

        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getHostName());  //地址
        System.out.println(socketAddress2.getPort());  //端口
    }
}
