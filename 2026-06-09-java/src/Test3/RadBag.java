package Test3;

import java.util.Random;

public class RadBag extends Thread {
    //定义红包个数
    private static int count;


    public static void setCount(int count) {
        RadBag.count = count;
    }

    //定义红包金额
    private static double money;


    public static void setMoney(double money) {
        RadBag.money = money;
    }

    //定义红包的最小金额
    private final double min = 0.01;

    public RadBag(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 先随机休息一下（0-100毫秒）
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (RadBag.class) {
            //先判断红包个数
            if (count == 0) {
                System.out.println(getName() + "没抢到");
            } else {
                //如果是最后一个红包自动获得剩余金额
                if (count == 1) {
                    System.out.println(getName() + "抢到" + Math.round(money * 100) / 100.0 + "元");
                } else {
                    //开始随机抢红包
                    Random r = new Random();
                    //金额是动态更新的
                    double bound = money - (count - 1) * min;   //随机红包金额
                    double v = r.nextDouble(0.01, bound);
                    System.out.println(getName() + "抢到" + Math.round(v * 100) / 100.0 + "元");
                    money -= v;
                }
                count--;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
