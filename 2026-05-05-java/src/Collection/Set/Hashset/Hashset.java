package Collection.Set.Hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hashset {
    //没有什么新方法通过set接口实现,方法跟collextion的方法一样
    public static void main(String[] args){
        //Hashset的特点就是可以查重 他也是无序的
        Set<String> set=new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        boolean aaa = set.add("aaa");       //不能重复插入相同元素,会返回false
        System.out.println(aaa);

        //打印Hashset
        System.out.println(set);

        //遍历(增强for)
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-----------");
        //foreach   Lambda表达式
        set.forEach(e-> System.out.println(e));
        System.out.println("---------------");
        //迭代器
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
