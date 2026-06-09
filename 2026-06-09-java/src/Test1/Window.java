package Test1;

public class Window extends Thread{
    private static int ticket=1000;

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
       while (true){
           synchronized (Window.class){
               if(ticket==0){
                   break;
               }else{
                   ticket--;
                   System.out.println("在"+getName()+"领取,"+"已领"+(1000-ticket)+"张票,还剩"+ticket+"张票");
               }
           }
           try {
               Thread.sleep(30);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}
