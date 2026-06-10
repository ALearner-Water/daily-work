package Test4;

import java.util.ArrayList;
import java.util.Random;

public class PrizeBox extends Thread {
    //可以用数组构造抽奖箱,但是后续去重复杂,所以使用集合更方便
    ArrayList<Integer> list = new ArrayList<>();  //可以在测试类中传递对象

    public PrizeBox(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            synchronized (PrizeBox.class) {
                if (list.size() == 0) { //如果抽完就直接跳出循环
                    break;
                } else {
                    Random random = new Random();
                    int index = random.nextInt(list.size());
                    System.out.println(getName() + "抽中" + list.get(index));
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
}
