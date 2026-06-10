package Test5;


import Test4.PrizeBox;

import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10);
        PrizeBox1 p1=new PrizeBox1("线程1",list);
        PrizeBox1 p2=new PrizeBox1("线程2",list);
        p1.start();
        p2.start();
    }
}
