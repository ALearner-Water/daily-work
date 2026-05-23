import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //键盘录入姓名年龄,要来判断异常,直到录入成功为止
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入姓名:");
                String name = sc.next();
                if(name.length() <= 2 || name.length() > 10){
                    throw new RuntimeException("姓名长度必须在3-10个字符之间");
                }
                System.out.println("请输入年龄:");
                int age = sc.nextInt();     //输入错误类型会抛出InputMismatchException
                if(age < 0 || age >40){
                    throw new RuntimeException("年龄必须在0-120之间");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("年龄必须是整数，请重新输入");
                sc.next(); // 清除缓冲区中的无效输入
            } catch (RuntimeException e) {
                e.printStackTrace();    //这里getmassage获取了throw的异常
            }
        }

        System.out.println("录入成功！");
        sc.close();
    }
}

