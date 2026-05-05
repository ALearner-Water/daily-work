package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Listbianli {
    public static void main(String[] args){
        //  1.迭代器遍历(先创建对象,再用hasnext方法,再用next()方法)
        //  2.增强for遍历(foreach)
        //  3.Lambda表达式遍历(foreach)
        //  4.普通for遍历
        //  5.列表迭代器遍历

        //创建集合
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        //  1.迭代器遍历(先创建对象,再用hasnext方法,再用next()方法)
        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //  2.增强for遍历(foreach)
        for (String s : list) {
            System.out.println(s);
        }

        //  3.Lambda表达式遍历(foreach)
        list.forEach(e-> System.out.println(e));

        //  4.普通for遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //  5.列表迭代器遍历
        ListIterator<String> it2=list.listIterator();
        while (it2.hasNext()){
            String t = it2.next();
            if(t.equals("aaa")){    //在aaa之后添加eee
                it2.add("eee");     //listiterator独有的add方法,普通迭代器没有
            }
            System.out.println(t);
        }
        System.out.println(list);
    }
}
