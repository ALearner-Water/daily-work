import java.util.HashMap;

public class StreamDemo2 {
    public static void main(String[] args){
        // 2.双列集合
        HashMap<String,String> map=new HashMap();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        //先使用keyset或者entryset或者values让集合变成单列集合
        map.keySet().stream().forEach(e->System.out.println(e));    //链式编程
        System.out.println("==================");
        map.values().stream().forEach(e->System.out.println(e));
        System.out.println("==================");
        map.entrySet().stream().forEach(e->System.out.println(e));
    }
}
