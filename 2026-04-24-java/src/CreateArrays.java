import java.sql.SQLOutput;
import java.util.Scanner;

public class CreateArrays {
    //此方法用来创建新数组
     public static int[] createArrays(int num){
        Scanner sc=new Scanner(System.in);
        //数组长度
        int arr[]=new int[num];

        //数组数据
        for (int j = 0; j < arr.length; j++) {
                System.out.print("请输入第" + (j + 1) + "个整数数据: ");
                int data = sc.nextInt();
                arr[j]=data;
        }
        System.out.print("您生成的数组为: [");
        for (int k = 0; k< arr.length; k++) {
            if(k<arr.length-1){
                System.out.print(arr[k]+",");
            }else{
                System.out.println(arr[k]+"]");
            }
        }
        return arr; //需要return arr让方法返回数组,让外界接收,可执行下一步操作
    }
}
