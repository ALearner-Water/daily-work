public class LinePool implements Runnable{
    @Override
    public void run() {
        while (true){
            synchronized ( LinePool.class){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
            break;
        }
    }
}
