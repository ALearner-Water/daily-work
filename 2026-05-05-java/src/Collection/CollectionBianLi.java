package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//遍历集合
public class CollectionBianLi {
    public static void main(String[] args){
        //1.迭代器遍历
        //2.增强for遍历(foreach)
        //3.Lambda表达式遍历

        //先创建集合
        Collection<String> coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //  1.迭代器遍历(先创建对象,再用hasnext方法,再用next()方法) -----不依赖索引
        Iterator<String> it =coll.iterator();   //默认指向0索引处,且遍历完不会复位
        while(it.hasNext()){    //判断集合中是否有元素
            String s = it.next();   //获取元素并移动指针,再一次循环中只能使用一次next()方法(用一次方法动一次指针)
            if(s.equals("aaa")){
                it.remove();        //只删除上一次next()方法获取的元素
            }
            System.out.println(s);
        }   //迭代器遍历时不能用集合的方法添加或删除元素,只能用迭代器的方法删除-----it.remove() 添加没有办法


        //  2.增强for遍历(foreach)------底层也是迭代器-------单列集合和数组词可以用-------双列不可以
        //for(数据类型 数据名: 要遍历的集合或者数组)
        for(String s:coll){     //快速生成coll.for
            System.out.println(s);
        }

        //  3.Lambda表达式遍历(foreach)------底层也是迭代器-------双列集合不可以
        coll.forEach(e-> System.out.println(e));
    }
}
