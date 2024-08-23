package URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {
    public static void main(String[] args) throws Exception {

        //1.下载地址
        URL url = new URL("http://localhost:8080/helloword/index.jsp");
        //2.连接到这个下载地址   HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();//打开连接

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("109951165561227373.jpg");//参数是文件名称

        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);//写出这个数据
        }

        //关闭资源
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
