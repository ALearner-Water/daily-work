package Test5;


import Test4.PrizeBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10);
        ExecutorService pool= Executors.newCachedThreadPool();

        pool.submit(new PrizeBox1("线程一",list));
        //使线程可以复用
        Thread.sleep(1000);
        pool.submit(new PrizeBox1("线程二",list));
        Thread.sleep(1000);
        pool.submit(new PrizeBox1("线程三",list));
        Thread.sleep(1000);
        //使用完要关闭线程池
        pool.shutdown();

    }
}
