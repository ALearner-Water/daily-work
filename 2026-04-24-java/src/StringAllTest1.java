import java.util.Scanner;

public class StringAllTest1 {
    //需要定义一个方法，把数组拼接成字符串返回
    //定义方法，生成任意新数组
    public static void main(String[] args){
        System.out.println("请输入您需要的数组长度:");
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();

        //自己生成新数组
        int arr[]=CreateArrays.createArrays(i);

        //调用方法拼接字符串
        ArrayCombine.arraycombine(arr);
    }
}
