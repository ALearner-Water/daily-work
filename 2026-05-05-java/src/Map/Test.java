package Map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    //是一个双列集合    (key,values)       里面的数据也不能重复,无序
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();

        //添加数据
        map.put("1","zhangsan");
        map.put("2","lisi");
        map.put("3","wangwu");
        System.out.println(map.put("1","zhengliu"));    //会直接覆盖旧values,返回值为旧values
        map.put("4","zhangsan");        //values可以重复,不会覆盖key
        System.out.println(map);

        //删除数据
        map.remove("2");    //通过key来删除数据
        System.out.println(map);

        //判断是否包含  containsKey()  containsValue()-->返回布尔值
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsKey("12"));
        System.out.println(map.containsValue("zhangsan"));
        System.out.println(map.containsValue("kkk"));

        //获取长度
        System.out.println(map.size());

        //claer()  清空数据
        map.clear();
        System.out.println(map);
    }

}
