package Collection.Set;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    //Set也是接口,不能创建对象,只能创建实现类对象
    public static void main(String[] args){
        Set<String> set=new HashSet<>();

        //add 添加元素
        set.add("aaa");
        set.add("bbb");
        boolean ccc = set.add("ccc");//会返回false,因为set集合不能添加重复元素
        boolean ccc2=set.add("ccc");
        System.out.println(ccc);
        System.out.println(ccc2);   //添加不成功

        System.out.println(set);        //他是无序的,也没有索引

        //遍历(都是无序的)
        set.forEach(e-> System.out.println(e)); //Lambda表达式遍历

        //增强for
        for (String s : set) {
            System.out.println(s);
        }
    }
}
