package Map.Treemap;

import java.util.*;

public class Treemap {
    //跟treeset一样是红黑树结构
    //可对键进行排序---->默认从小到大,也可自己制定规则
    public static void main(String[] args){
        Map<String, String> map = new TreeMap<>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");

        //创建key集合遍历
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-----------------");

        //创建value集合遍历
        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println(s);
        }
        System.out.println("-----------------");

        //使用键值对遍历
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }

    }
}
