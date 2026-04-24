import java.util.Scanner;

public class StringAllTest2 {
    public static void main(String[] args) {
        //拼接字符串 8个为一行 不够用的用0填充
        System.out.println("请输入字符串:");
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        //第一种方法,在拆分前就先补成8的倍数
        if((str.length()% 8) != 0){
            String cnt="00000000";  //先补充8个0,然后根据余数再截取0
            str+=cnt.substring(0,8-str.length()%8);
            System.out.println(str);
        }
        for (int i = 0; i < str.length(); i+=8) {
            System.out.println(str.substring(i,i+8));   //每次截取8个
        }
    }
}