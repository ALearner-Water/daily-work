package Rannable;

public class Classimplement implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            //因为接口里面没有getName方法，所以只能用Thread类中的getName方法
            //使用currentThread()方法获取当前线程,再调用getName方法
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
