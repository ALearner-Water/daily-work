import java.util.Scanner;

public class RemoveTarget {
    public static void main(String[] args){
        //决定数组长度
        System.out.println("请输入数组长度");
        Scanner sc=new Scanner(System.in);
        int arrlong=sc.nextInt();
        int arr[]=new int[arrlong];
        //决定数组元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第"+(i+1)+"个元素: ");
            arr[i]=sc.nextInt();
        }
        //遍历数组打印
        System.out.print("该数组为:");
        System.out.print(" [");
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.println(arr[i]+"]");
            }
        }
        //确认目标值
        System.out.print("请输入想要去除的元素: ");
        int target=sc.nextInt();
        //开始移除(双指针)
        int slow=0;
        int fast=0;
        while(fast<arr.length) {
            if (arr[fast] != target) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        if(slow!=0) {
            System.out.print("剩下元素组成的数组为: [");
            for (int i = 0; i < slow; i++) {
                if (i < slow - 1) {
                    System.out.print(arr[i] + ",");
                } else {
                    System.out.println(arr[i] + "]");
                }
            }
        }else{
            System.out.println("元素被全部去除");
        }
    }
}
