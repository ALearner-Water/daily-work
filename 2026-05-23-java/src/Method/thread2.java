package Method;

public class thread2 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() +"   "+ i);
            Thread.yield(); //礼让线程，让cpu重新挑选线程执行，尽可能让线程均匀执行
        }
    }
}
