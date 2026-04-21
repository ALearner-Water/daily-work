package StringDemo;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        //1. public char chatAt(int index); 根据索引返回数组。
        //2. public int length();

        //1. public char chatAt(int index); 根据索引返回数组
        String name = "hyhshw";
        char a = name.charAt(5);    //使用索引定位，不能超过最大长度
        System.out.println(a);

        //2. public int length();
        int b=name.length();
        System.out.println(b);

        //3.键盘随机录入字符串,遍历字符串
        Scanner sc=new Scanner(System.in);
        String name1=sc.next();
        for (int i = 0; i < name1.length(); i++) {
            System.out.println(name1.charAt(i));
        }




    }
}
