package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapBianLi1 {
    public static void main(String[] args) {
        //第一种方式,键找找值遍历
        Map<String, String> map = new HashMap<>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");
        //获取所有键
        Set<String> set = map.keySet(); //将所有键放入set集合中
        //可以使用三种方法遍历
        //  1.迭代器
        Iterator it = set.iterator();
        while (it.hasNext()) {
            //利用map.get方法获取值
            System.out.println(map.get(it.next()));
        }
        System.out.println("-----------------");
        //  2.增强for循环
        for (String s : set) {
            System.out.println(map.get(s));
        }
        System.out.println("-----------------");
        //  3.foreach
        set.forEach(e -> System.out.println(map.get(e)));
    }
}
