package demo01;

//练习Thread，多线程同步下载图片
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 开启主线程，继承Thread
 */
public class ThreadTest2 extends Thread {
    private String url;
    private String name;

    public ThreadTest2(String url,String name){
        this.url=url;
        this.name=name;
    }

    public static void main(String[] args) {
        //主线程
        ThreadTest2 threadTest1=new ThreadTest2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","百度.jpg");
        ThreadTest2 threadTest2=new ThreadTest2("https://i02piccdn.sogoucdn.com/320259445591811f","2.jpg");
        ThreadTest2 threadTest3=new ThreadTest2("https://i04piccdn.sogoucdn.com/f7cb59c1d9af2a59","3.jpg");

        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
    }

    //执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader=new WebDownLoader();
        try {
            webDownLoader.Down(url,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("下载了文件"+name+"的文件");
    }
}


class WebDownLoader{
    //下载方法
    public void Down(String url,String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}
