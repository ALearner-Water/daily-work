package Collection.List;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        //1.add.,直接添加到末尾
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);

        //2.add.,添加到指定位置(不能超过集合长度)
        list.add(0,"eee");
        System.out.println(list);

        //3.remove.,删除指定元素
        String remove = list.remove(0);//能返回被删除的对象
        System.out.println(remove);
        System.out.println(list);

        //4.set.,修改指定位置的元素
        String fff = list.set(1, "fff");//返回被修改之前的元素
        System.out.println(fff);
        System.out.println(list);

        //5.get.,获取指定位置的元素
        String s = list.get(1);
        System.out.println(s);
    }
}
