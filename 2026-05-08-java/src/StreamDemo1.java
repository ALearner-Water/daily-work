import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class StreamDemo1 {
                    //STREAM流就是将集合里面的数据放入流水线
    public static void main(String[] args) {
/*  单列集合        default Stream<T> stream()  collection里面的默认方法
    双列集合         不可直接使用stream流,转成单列集合之后才可以使用
    数组            使用arrays工具类的方法即可使用
    一堆零散数据      使用stream自带的静态方法
 */
        //  1.单列集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d","e");   //使用collections工具类
        list.stream().forEach(e-> System.out.println(e));
        //使用list调用stream流然后使用lambda表达式输出遍历


    }
}
