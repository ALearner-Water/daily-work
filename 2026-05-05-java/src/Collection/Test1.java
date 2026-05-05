package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Test1 {
    public static void main(String[] args) {

        //是一个单列集合
        //Collection是一个接口,只能创建他实现类的对象(Arraylist)
        Collection<String> coll = new ArrayList<>();  //平常可以不用这样写

        //add 添加元素
        coll.add("aaa");    //返回值为布尔值   list里面永true     set里面有false有true
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll);

        //contains 判断元素是否存在,是根据equals方法来判断,如果是自定义对象,则需要重写equals方法
        boolean aaa = coll.contains("aaa");
        boolean jjj2 = coll.contains("jjj");
        System.out.println(aaa);
        System.out.println(jjj2);

        //size 获取集合长度
        System.out.println(coll.size());

        //remove 删除元素(返回值为布尔)   不能使用索引,只能通过对象删除
        boolean bbb = coll.remove("bbb");
        boolean jjj = coll.remove("jjj");
        System.out.println(bbb);
        System.out.println(jjj);

        //clear 清空集合
        coll.clear();
        System.out.println(coll);
    }
}
