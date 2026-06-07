public class Cook extends Thread{
    @Override
    public void run() {
        while ( true){
            synchronized (Dack.class){
                if (Dack.maxCount==0){
                    break;
                }else{
                    if (Dack.food==0){
                        Dack.food=1;
                        System.out.println("开始做面条");
                        //唤醒另一个线程
                        Dack.class.notify();
                    }else {
                        try {
                            Dack.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
