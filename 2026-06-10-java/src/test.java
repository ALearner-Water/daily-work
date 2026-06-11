import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) throws InterruptedException {
        //获取线程池来存线程实现复用功能
        ExecutorService pool=Executors.newCachedThreadPool();   //这里是无限的 newFixedThreadPool是有限的
        //提交任务运行
        pool.submit(new LinePool());
        pool.submit(new LinePool());        //如果没有等待时间，则有可能会开启新线程来执行新任务
        pool.submit(new LinePool());        //如果有等待时间，则在等待时间后上一个任务已经做完，则会复用线程


        //任务结束之后要关闭线程池
        pool.shutdown();
    }
}
    