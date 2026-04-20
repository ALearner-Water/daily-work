package StringDemo;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Scanner;

public class Test2 {
    public void main(String[] args){
        String name="hyh";
        String s1="535070466";
        Scanner sc=new Scanner(System.in);          //用户输入密码,只有3次机会
        for (int i=1;i<4;i++) {

            System.out.println("请输入用户名");//创建用户名
            String name2=sc.next(); //创建了一个新内存地址，所以不能用==得用equals

            System.out.println("请输入密码");//创建密码
            String s2 = sc.next();  //创建了一个新内存地址，所以不能用==得用equals

            //使用s1调用equals方法  不会忽略大小写   equalsIgnorecase会忽略大小写
            if(s1.equals(s2)&&name.equals(name2)) {
                System.out.println("登陆成功");
                break; //成功就直接返回 or return

            }else if(3-i!=0){
                System.out.println("用户名或密码输入错误");
                System.out.println("还有"+(3-i)+"次机会");
                } else{
                System.out.println("请稍后再重新输入");
            }

        }
    }
}
