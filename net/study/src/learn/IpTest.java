package learn;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机地址
        InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
        System.out.println("inetAddress1 = " + inetAddress1);
        InetAddress inetAddress3 = InetAddress.getByName("localhost");
        System.out.println("inetAddress3 = " + inetAddress3);
        InetAddress inetAddress4 = InetAddress.getLocalHost();
        System.out.println("inetAddress4 = " + inetAddress4);



        //查询网络ip地址
        InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress2 = " + inetAddress2);


        //常用方法
       // System.out.println(inetAddress2.getAddress());
        System.out.println(inetAddress2.getCanonicalHostName( ));  //规范的名字
        System.out.println(inetAddress2.getHostAddress( ));   //ip
        System.out.println( inetAddress2.getHostName());     //域名或者自己电脑的名字

    }

}
