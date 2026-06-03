package Method;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        thread1 t1 = new thread1();
        t1.setName("线程1");
        t1.start();
        t1.join();  //把线程插入当前线程之前，等待上面的线程结束才会执行下面的线程
        for (int i = 0; i < 10; i++) {
            System.out.println("线程2");
        }
    }
}
