public class SellTicket2 implements Runnable {      //使用同步方法写售票
    int ticket = 0;    //不需要静态，因为只需要创建一次runnable对象

    @Override
    public void run() {
        while (sellTicket()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private synchronized boolean sellTicket() {
        if (ticket < 20) {
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
        } else return false;
        return true;
    }
    public static void main(String[] args) {
        SellTicket2 st1 = new SellTicket2();
        Thread t1 = new Thread(st1, "窗口一");
        Thread t2 = new Thread(st1, "窗口二");
        Thread t3 = new Thread(st1, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
