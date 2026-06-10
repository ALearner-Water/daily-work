import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) throws InterruptedException {
        //获取线程池来存线程实现复用功能
        ExecutorService pool = Executors.newCachedThreadPool();
        //提交任务运行
        pool.submit(new LinePool());
        pool.submit(new LinePool());

        pool.submit(new LinePool());


        //任务结束之后要关闭线程池
        pool.shutdown();
    }
}
