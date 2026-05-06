package Collection.Set.Hashset;

import java.util.HashSet;
import java.util.Set;

public class Hashset2 {
    //他查重的时候底层使用的是equals()方法，如果泛型为自己写的对象的话需要重写equals方法
    public static void main(String[] args) {
        Set<HashsetStudent> set = new HashSet<>();
        //创建对象
        HashsetStudent hs1 = new HashsetStudent(12, "zhangsan");
        HashsetStudent hs2 = new HashsetStudent(13, "lisi");
        HashsetStudent hs3 = new HashsetStudent(14, "wangwu");
        HashsetStudent hs4 = new HashsetStudent(12, "zhangsan");       //重写equals和hashcode方法才会查重

        //添加对象
        set.add(hs1);
        set.add(hs2);
        set.add(hs3);
        set.add(hs4);

        for (HashsetStudent hashsetStudent : set) {     //要重写tostring方法才能打印值
            System.out.println(hashsetStudent);
        }
    }
}
