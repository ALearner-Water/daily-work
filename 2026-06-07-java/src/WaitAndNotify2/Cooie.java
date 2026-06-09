package WaitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooie extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cooie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {  //取数据
            try {
                String take = queue.take(); //源码有锁不需要再写synchronized
                System.out.println(take + "+1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
