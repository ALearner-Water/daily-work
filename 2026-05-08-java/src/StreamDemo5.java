import java.util.ArrayList;
import java.util.Collections;

public class StreamDemo5 {
    public static void main(String[] args){
        //stream流中的中间方法
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张三","张三丰","张无忌","周连","往往","里斯");

        //  1.过滤方法  filter()
        list.stream().filter(e->e.startsWith("张"))
                .filter(e->e.length()==3)
                .forEach(e-> System.out.println(e));    //可以折行写lambda表达式

        //中间方法可以使用多次,但是原来的stream流只能用一次,所以使用链式编程会好

        //且修改stream流中的数据像filter()一样,不会修改原集合里面的值

        //  2.获取前几个元素   limit(n) -> 最多获取前n个元素
        System.out.println("------------------------");
        list.stream().limit(3).forEach(e-> System.out.println(e));  //3代表前几个元素

        //  3.跳过几个元素   skip()
        System.out.println("------------------------");
        list.stream().skip(3).forEach(e-> System.out.println(e));   //3代表跳过几个元素

        //这两个方法也可以链式编程
        System.out.println("------------------------");
        list.stream().skip(2).limit(9).forEach(e-> System.out.println(e));  //这里limit超出list长度也不会报错

    }
}
