package WaitAndNotify2;

import SimpleWaitAndNotify.Cooloe;

import java.util.concurrent.ArrayBlockingQueue;

public class test {
    //使用阻塞队列完成等待唤醒机制
    //写数据和接数据必须在同一个队列,所以在main方法里面创建队列,然后通过构造方法直接赋值
    public static void main(String[] args){
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1);   //array需要有界
        Cook cook=new Cook(queue);
        cook.start();
        Cooie cooie=new Cooie(queue);
        cooie.start();
    }
}
