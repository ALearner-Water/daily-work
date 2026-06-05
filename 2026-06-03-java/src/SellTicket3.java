import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket3 extends Thread {
    private static int ticket = 1;

    public SellTicket3(String name) {
        super(name);
    }

    //使用Lock对象来开关锁
    static Lock lock = new ReentrantLock();    //lock是一个接口，ReentrantLock是一个实现类

    @Override
    public void run() {
        while (true) {
            lock.lock();    //加锁
            try {
                if (ticket <= 100) {
                    System.out.println(this.getName() + "正在卖第" + ticket + "张票");
                    ticket++;
                } else break;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }   //保证程序一定会结束，释放锁
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SellTicket3 st1 = new SellTicket3("窗口一");
        SellTicket3 st2 = new SellTicket3("窗口二");
        SellTicket3 st3 = new SellTicket3("窗口三");
        st1.start();
        st2.start();
        st3.start();
    }

}


