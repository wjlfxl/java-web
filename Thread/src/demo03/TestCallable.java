package demo03;

import demo01.ThreadTest2;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.*;
//创建多线程的方式三
/**
 * 1.实现Callable接口
 * 2.实现call（）
 * 3.创建目标对象
 * 4.创建执行服务: ExecutorService ser = Executors.newFixedThreadPool(1);
 * 5.提交执行: Future<Boolean> result1 = ser.submit(t1);
 * 6.获取结果: boolean r1 = result1.get();
 * 7.关闭服务: ser.shutdownNow();
 */
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable callable1=new TestCallable("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","百度.jpg");
        TestCallable callable2=new TestCallable("https://i02piccdn.sogoucdn.com/320259445591811f","2.jpg");
        TestCallable callable3=new TestCallable("https://i04piccdn.sogoucdn.com/f7cb59c1d9af2a59","3.jpg");

        //创建执行服务   数字代表几个线程
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = ser.submit(callable1);
        Future<Boolean> result2 = ser.submit(callable2);
        Future<Boolean> result3 = ser.submit(callable3);
         //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();
    }

    //执行体
    @Override
    public Boolean call() throws IOException {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.Down(url,name);
        System.out.println("下载了文件"+name+"的文件");
        return true;
    }

}
class WebDownLoader{
    //下载方法
    public void Down(String url,String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}