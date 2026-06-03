package Method;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        //currentThread 能获取到当前工作的线程对象
        Thread t=Thread.currentThread();
        System.out.println(t.getName());
        //获取了main线程，是主方法
    }
}
