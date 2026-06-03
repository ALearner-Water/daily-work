package Method;

public class getNameDemo extends Thread{
    //线程是有默认的名字的，但是可以通过setName()方法修改

    public getNameDemo(String name) {   //如果没有构造方法，那么就不能使用构造方法修改名字和创建线程
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //调用sleep使线程休眠
            try {
                Thread.sleep(1000);     //需要try catch
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "   "+i);
        }
    }
    public static void main(String[] args) {
        getNameDemo g1 = new getNameDemo("你好"); //使用构造方法修改名字的时候需要让子类继承Thread类的构造方法
        getNameDemo g2 = new getNameDemo("好你");
        g1.start();
        g2.start();
    }
}
