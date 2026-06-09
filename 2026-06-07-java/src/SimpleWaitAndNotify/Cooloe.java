package SimpleWaitAndNotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooloe extends Thread {

    @Override
    public void run() {
        //写同步代码块的逻辑，先写循环，再写锁，再判断
        while (true) {
            synchronized (Dack.class) {
                //先写是否结束的逻辑
                if (Dack.maxCount == 0) {   //循环结束的条件
                    break;
                } else {
                    if (Dack.food == 1) {
                        //还没停止就继续运行
                        Dack.maxCount--;
                        System.out.println("还可以再吃" + Dack.maxCount + "碗面条");
                        Dack.food = 0;  //改变状态(已经吃完)
                        //然后唤醒另一个线程继续做
                        Dack.class.notifyAll();
                    } else {
                        //如果没有面条，就等待
                        try {
                            Dack.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
