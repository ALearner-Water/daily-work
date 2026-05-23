package Thread;

public class ThreadDemo1 {
    //多线程的第一种启动方式
    //1.自己写一个类继承Thread类 2.重写run方法 3.创建对象 4.调用start方法启动线程
    public static void main(String[] args) {
        Classextend cl = new Classextend();
        //不是直接调用run方法 cl.run();需要调用start方法才算启动线程

        //验证线程是交替运行的，并发
        Classextend cl2 = new Classextend();
        cl.setName("kk");
        cl2.setName("mm");
        cl.start();
        cl2.start();
    }
}
