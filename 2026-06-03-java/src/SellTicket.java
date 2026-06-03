public class SellTicket extends Thread{
    private static int ticket = 1;    //需要使用静态修饰符来使ticktet变量是所有线程共享的

    public SellTicket(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized (SellTicket.class){    //同步代码块
                if (ticket <= 100) {
                    System.out.println(this.getName() + "正在卖第" + ticket + "张票");
                    ticket++;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
