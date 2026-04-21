package StringDemo;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        System.out.println("该数组长度为6，请输入6个数字");
        //创建一个方法可以遍历数组后用字符串拼接打印出来
        int arr[] = new int[6];
        Scanner sc=new Scanner(System.in);
        //录入数组
        for (int i = 0; i < arr.length; i++) {
            int a=sc.nextInt();
            arr[i]=a;
        }
        Arraytool.array(arr);
    }

}
