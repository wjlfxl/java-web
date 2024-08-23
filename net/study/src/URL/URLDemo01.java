package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://blog.csdn.net/hanpiyo?type=blog");
        System.out.println(url.getProtocol());//获取协议名
        System.out.println(url.getHost());//获取主机ip
        System.out.println(url.getPort());//获取端口号
        System.out.println(url.getPath());//获取文件
        System.out.println(url.getFile());//获取全路径
        System.out.println(url.getQuery());//获取查询的名字，参数
    }
}
