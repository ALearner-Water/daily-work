package Test5;

import Test4.PrizeBox;

import java.util.ArrayList;
import java.util.Random;

public class PrizeBox1 extends Thread {
    ArrayList<Integer> list = new ArrayList<>();  //可以在测试类中传递对象

    ArrayList<Integer> list1=new ArrayList<>();
    ArrayList<Integer> list2=new ArrayList<>();

    public PrizeBox1(String name, ArrayList<Integer> list) {
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
                    if ("线程1".equals(getName())){
                        StringBuilder sb1=new StringBuilder();
                        for (int i = 0; i < list1.size(); i++) {
                            if(i!=list1.size()-1){
                                sb1.append(list1.get(i)+",");
                            }else {
                                sb1.append(list1.get(i));
                            }
                        }
                        System.out.println("线程1抽奖结果分别为: "+sb1.toString()+" 最大值为"+Max(list1)+" 总和为: "+Sum(list1));
                    }else {
                        StringBuilder sb2=new StringBuilder();
                        for (int i = 0; i < list2.size(); i++) {
                            if(i!=list2.size()-1){
                                sb2.append(list2.get(i)+",");
                            }else {
                                sb2.append(list2.get(i));
                            }
                        }
                        System.out.println("线程2抽奖结果分别为: "+sb2.toString()+" 最大值为"+Max(list2)+" 总和为: "+Sum(list2));
                    }
                    break;
                } else {
                    Random random = new Random();
                    int index = random.nextInt(list.size());
                    if (getName().equals("线程1")) {
                        list1.add(list.get(index));
                    }else {
                        list2.add(list.get(index));
                    }
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
    public int Sum(ArrayList< Integer> list){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }
    //求最大值
    public int Max(ArrayList< Integer> list){
        int max=list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }
}
