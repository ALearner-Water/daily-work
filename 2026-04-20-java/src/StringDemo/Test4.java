package StringDemo;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args){
        System.out.println("请输入字符串");
        //键盘录入字符串
        Scanner sc=new Scanner(System.in);
        int upcnt=0;
        int lowcnt=0;
        int num=0;
        int annum=0;
        //统计字符串个数
        String name=sc.next();
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i)>='a'&&name.charAt(i)<='z'){
                lowcnt++;   //小写
            } else if (name.charAt(i)>='A'&&name.charAt(i)<='Z') {
                upcnt++;    //大写
            } else if (name.charAt(i)>='0'&&name.charAt(i)<='9') {
                num++;  //数字
            }else{
                annum++;    //其他
            }
        }
        System.out.println("大写出现了"+upcnt+"次");
        System.out.println("小写出现了"+lowcnt+"次");
        System.out.println("数字出现了"+num+"次");
        System.out.println("其他字符出现了"+annum+"次");
    }
}
