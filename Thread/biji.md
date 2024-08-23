#创建多线程的方式一
##1.开启主线程，继承Thread
##2.重写run（）
## 3.调用start（）
```java
 public class ThreadTest1 extends Thread {
  public static void main(String[] args) {
  //主线程
       //创建一个线程对象
        ThreadTest1 threadTest1=new ThreadTest1();
    //调用start方法开启进程对象
        threadTest1.start();
        
        for (int i = 0; i < 200; i++) {
            System.out.println("main-------"+i);
        }
    }

    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i < 20; i++) {
            System.out.println("run-------"+i);
        }
    }
}
```
#
#创建多线程的方式二
## 1.实现Runnable接口
##2.实现run（）
## 3.执行线程需要丢入runnable接口实现类
##4.调用start方法。
```java
  public class ThreadTest3 implements Runnable {
  @Override
  public void run() {
      //run方法线程
      for (int i = 0; i < 20; i++) {
      System.out.println("run-------"+i);
      }
}

  public static void main(String[] args) {
  //创建Runnable接口的实现类
  ThreadTest3 ThreadTest3=new ThreadTest3();

       //创建线程对象，通过线程对象来开启我们的线程，代理
       Thread thread=new Thread(ThreadTest3);

        //调用start方法开启进程对象
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main-------"+i);
        }
    }
}
```

##发现问题:多个线程操作同一个资源的情况下,线程不安全，数据紊乱。


#创建多线程的方式三
###1.实现Callable接口
###2.实现call（）
###3.创建目标对象
###4.创建执行服务: ExecutorService ser = Executors.newFixedThreadPool(1);
###5.提交执行: Future<Boolean> result1 = ser.submit(t1);
###6.获取结果: boolean r1 = result1.get();
###7.关闭服务: ser.shutdownNow();
```java
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
```
 