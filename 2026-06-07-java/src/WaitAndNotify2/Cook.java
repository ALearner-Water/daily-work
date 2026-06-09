package WaitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        //在里面放数据
        while (true) {
            try {
                queue.put("饭饭");    //用队列放
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
