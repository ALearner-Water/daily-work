package Method;

public class PriorDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
    public static void main(String[] args){
        PriorDemo p1 = new PriorDemo();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        System.out.println(t1.getPriority());   //获取线程优先级
        System.out.println(t2.getPriority());
    }
}
