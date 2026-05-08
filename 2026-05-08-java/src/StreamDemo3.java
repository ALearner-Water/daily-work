import java.util.Arrays;

public class StreamDemo3 {
    //数组
    public static void main(String[] args){
        int arr1[]={1,2,3,4,5,6,7};
        //使用Arrays工具类来使用stream流
        Arrays.stream(arr1).forEach(e-> System.out.println(e));
        //如果直接打印Arrays.stream(arr1)得到的是一个流对象[java.util.stream.IntPipeline$Head@63961c42]
    }
}
