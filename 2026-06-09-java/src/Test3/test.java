package Test3;

import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入红包个数:");
        int count=sc.nextInt();
        RadBag.setCount(count);

        System.out.println("请输入红包金额:");
        double money=sc.nextDouble();
        RadBag.setMoney( money);

        for (int i = 0; i < count+2; i++) {
            RadBag r=new RadBag("线程"+i);
            r.start();
        }

    }
}
