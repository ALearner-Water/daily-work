package SimpleWaitAndNotify;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class test {
    public static void main(String[] args){
        Cook cook=new Cook();
        cook.start();
        Cooloe cooloe=new Cooloe();
        cooloe.start();
    }
}
