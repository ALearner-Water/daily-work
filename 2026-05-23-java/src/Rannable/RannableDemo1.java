package Rannable;

public class RannableDemo1 {
    //线程开启的第二种方式：实现Runnable接口
    //再重写run方法 创建对象 创建Thread对象 启动线程
    public static void main(String[] args){
        Classimplement cl = new Classimplement();
        //创建Thread对象
        Thread t1=new Thread(cl);    //将对象传递进去
        Thread t2=new Thread(cl);
        t1.setName("kk");
        t2.setName("mm");
        t1.start(); //开启线程
        t2.start();
    }
}
