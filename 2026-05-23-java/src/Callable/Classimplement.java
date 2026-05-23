package Callable;

import java.util.concurrent.Callable;

//此接口有泛型,可以有指定类型的返回值 可以拿到线程处理的结果
public class Classimplement implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
