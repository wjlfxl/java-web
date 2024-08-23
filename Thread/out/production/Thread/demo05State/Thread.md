方法--------------------------------说明
####setPriority(int newPriority)----- 更改线程的优先级 
####static void sleep(long millis)--- 在指定的毫秒数内让当前正在执行的线程休眠
####void join()-----------------------等待该线程终止
####static void yield()-------------- 暂停当前正在执行的线程对象，并执行其他线程
####void interrupt()------------------中断线程，别用这个方式
####boolean isAlive()------------------ 测试线程是否处于活动状态
#
#
###sleep (时间)指定当前线程阻塞的毫秒数;
###sleep存在异常 InterruptedException;
###sleep时间达到后线程进入就绪状态;
###sleep可以模拟网络延时，倒计时等。
###每一个对象都有一个锁， sleep不会释放锁;
