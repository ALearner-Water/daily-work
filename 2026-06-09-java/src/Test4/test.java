package Test4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10);
        PrizeBox p1=new PrizeBox("线程1",list);
        PrizeBox p2=new PrizeBox("线程2",list);
        p1.start();
        p2.start();
    }
}
