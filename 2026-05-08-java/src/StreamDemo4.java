import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args){
        // 4.一堆零散数据,使用stream自带的静态方法
        Stream.of("张三","李四","王五","赵六").forEach(e-> System.out.println(e));
        System.out.println("------------------------");
        //也能打印引用数据类型的数组
        String arr[]={"a","b","c","d","e"};
        Stream.of(arr).forEach(e-> System.out.println(e));
        System.out.println("------------------------");
        //但是打印不了基本数据类型的数组
        int arr1[]={1,2,3,4,5,6,7};
        Stream.of(arr1).forEach(e-> System.out.println(e)); //[I@3a71f4dd会输出地址值
        //因为把一整个基本数据类型的数组当成一个元素放到stream流中了
    }
}
