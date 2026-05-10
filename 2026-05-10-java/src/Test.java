import java.text.NumberFormat;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //键盘录入姓名年龄,要来判断异常,直到录入成功为止
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名:");
        while (true) {
            try {
                String name = sc.next();
                if(name.length()<=2||name.length()>10){
                    throw new RuntimeException();
                }
                System.out.println("请输入年龄:");
                int age=sc.nextInt();
                break;
            } catch (RuntimeException e) {
                System.out.println("姓名长度有误,请输入正确的姓名");
            }catch ( Exception e){
                System.out.println("请输入正确的年龄");
            }
        }
    }

}
