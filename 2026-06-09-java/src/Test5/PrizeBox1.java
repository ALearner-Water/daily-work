package Test5;

import java.util.ArrayList;
import java.util.Random;

public class PrizeBox1 extends Thread {
    ArrayList<Integer> list = new ArrayList<>();  //可以在测试类中传递对象


    public PrizeBox1(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> listbox = new ArrayList<>();  //将集合创建放在run方法，避免多线程情况下，多个线程同时创建对象
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            synchronized (PrizeBox1.class) {
                if (list.size() == 0) { //如果抽完就直接跳出循环
                    StringBuilder sb1 = new StringBuilder();
                    for (int i = 0; i < listbox.size(); i++) {
                        if (i != listbox.size() - 1) {
                            sb1.append(listbox.get(i) + ",");
                        } else {
                            sb1.append(listbox.get(i));
                        }
                    }
                    System.out.println(getName() + "抽奖结果分别为: " + sb1.toString() + " 最大值为" + Max(listbox) + " 总和为: " + Sum(listbox));
                        break;
                } else {
                    Random random = new Random();
                    int index = random.nextInt(list.size());
                    listbox.add(list.get(index));
                    list.remove(index);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //求最大值和求和
    public int Sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    //求最大值
    public int Max(ArrayList<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
