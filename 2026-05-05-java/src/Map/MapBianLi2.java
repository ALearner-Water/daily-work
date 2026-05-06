package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapBianLi2 {
    public static void main(String[] args){
        //第二种方法,键值对遍历
        //第一种方式,键找找值遍历
        Map<String, String> map = new HashMap<>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");

        Set<Map.Entry<String, String>> entries = map.entrySet();    //获取键值对集合

        // 1.迭代器
        Iterator it=entries.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-----------------");

        // 2.增强for循环
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-----------------");

        // 3.foreach
        entries.forEach(e -> System.out.println(e));
        System.out.println("-----------------");

        // 4.map.forEach
        map.forEach((k,v) -> System.out.println(k+"--"+v));
    }
}
