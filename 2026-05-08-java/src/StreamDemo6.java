import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamDemo6 {
    public static void main(String[] args){
        //  4.数据查重  distinct()
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张三","张三丰","张无忌","张三","张三丰","张无忌","张三","张三丰","张无忌");
        //使用list的stream流对象调用distinct()即可
        list.stream().distinct().forEach(e-> System.out.println(e));
        //是基于equals方法和hashcode方法来查,所以使用自定义类时,必须重写hashcode()和equals()方法

        //  5.  合并stream流->合并的两个集合最好是相同类型   -> stream.concat()->是stream的静态方法
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"hao","king","jia");
        Stream.concat(list.stream(),list1.stream()).forEach(e-> System.out.println(e));
        //里面是两个集合的stream流对象
    }
}
