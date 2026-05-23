package Thread;

public class Classextend extends Thread{
    @Override
    public void run() {
        //书写线程任务
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + i);
        }
    }
}
