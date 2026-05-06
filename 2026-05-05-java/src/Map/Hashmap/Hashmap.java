package Map.Hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    //是map的实现类,直接使用map里面的方法就ok  无序,不重复,无索引
    //底层原理--->哈希表
    //所以有equals方法和hashcode方法来保持唯一的键---->存储自定义的也不需要重写
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");

        //遍历key
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }

        //遍历values
        Collection<String> values = map.values();
        for (String s : values) {  //将创建的值集合直接遍历
            System.out.println(s);
        }
    }

}
