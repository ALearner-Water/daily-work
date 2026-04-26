import java.util.Random;
import java.util.Scanner;

public class StringAllTest3 {
    public static void main(String[] args) {

        //打乱字符串
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //先变成数组再进行打乱
        char arr[] = str.toCharArray();
        //打乱数组
        Random r=new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex=r.nextInt(arr.length);
            char temp=arr[i];   //现在是字符，不能是int
            arr[i]=arr[randomIndex];
            arr[randomIndex]=temp;
        }

        //使用构造方法转成字符串
        String str2=new String(arr);
        System.out.println(str2);
    }
}
