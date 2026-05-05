package Collection.List;

import java.util.ArrayList;

public class ArraysList {
    public static void main(String[] args){
        //arraylist其实是一个集合
        //尖括号代表范形,限制集合中元素类型,只用写一次
        ArrayList<String> list=new ArrayList<>();

        //常见方法
        //1 add.,直接添加到末尾
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);
        //2 add.,添加到指定位置(不能超过集合长度)
        list.add(0,"999");
        System.out.println(list);

        //3 remove.,删除指定元素
        list.remove("aaa");
        System.out.println(list);
        //4 remove.,删除指定位置的元素
        list.remove(1);
        System.out.println(list);

        //5 set.,修改指定位置的元素
        list.set(0,"444");
        System.out.println(list);

        //6 get.,获取指定位置的元素
        String s = list.get(0);
        System.out.println(s);

        //7 size.,获取集合长度 与get一起使用可以遍历集合
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
