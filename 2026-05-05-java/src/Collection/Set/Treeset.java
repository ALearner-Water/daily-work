package Collection.Set;

import java.util.Iterator;
import java.util.Set;

public class Treeset {
    public static void main(String[] args) {
        //跟Hashset一样实现了Set接口,所以使用的方法跟collection一样,而且还可以排序
        Set<Integer> set = new java.util.TreeSet<>();
        set.add(1);
        set.add(5);
        set.add(8);
        set.add(2);

        System.out.println(set);        //会自动排序,但是如果是自己写的对象则需要重写comparable方法来排序,不然程序会报错

        //增强for遍历
        for (Integer i : set) {
            System.out.println(i);
        }
        System.out.println("---------------");
        //迭代器
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("---------------");
        //Lambda表达式
        set.forEach(e-> System.out.println(e));
    }
}
