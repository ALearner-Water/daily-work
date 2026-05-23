package Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //多线程的第三种实现方式：实现Callable接口
        //1. 创建Callable对象 3.创建FutureTask对象 4.创建Thread对象 5.启动线程 6.获取结果
        Classimplement cl = new Classimplement();
        FutureTask<Integer> ft = new FutureTask<>(cl);  //获取结果
        Thread t1 = new Thread(ft);   //是执行ft
        t1.start();
        Integer i = ft.get();   //有返回值且需要抛出异常
        System.out.println(i);

    }
}
