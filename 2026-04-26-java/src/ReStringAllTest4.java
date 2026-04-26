import java.util.Scanner;

public class ReStringAllTest4 {
    //重现 输入两个字符串,相加之后输出  (使用数组)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        //哪个数组长就用那个数组
        int len = 0;
        if (str1.length() > str2.length()) {
            len = str1.length();
        } else {
            len = str2.length();
        }
        //写方法把字符串变成数组
        int arr1[]=copydata1(str1,len);
        int arr2[]=copydata1(str2,len);
        //定义新数组,长度+1
        int sum[]=new int[len+1];
        //开始计算(从大到小),判定条件是len,因为arr[]的长度就是len
        int num=0;  //定义进位
        for (int i = len-1; i >=0 ; i--) {
            int temp=arr1[i]+arr2[i]+num;   //结果=数组1+数组2+进位
            sum[i+1]=temp%10;   //因为sum数组长度大一
            num=temp/10;    //进位计算
        }
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //循环没有判断sum[0]
        sum[0]=num;
        if(sum[0]!=0){
            sb.append(sum[0]);
        }
            for (int i = 1; i < sum.length; i++) {
                sb.append(sum[i]);
            }
        System.out.println(sb.toString());
    }
    public static int[] copydata1(String str,int len){
        int arr[]=new int[len];
        //把字符串数据存入(使用ascii码) ,从后往前，前面补0
        int index=len-1;
        for (int length = str.length()-1; length >=0 ; length--) {
            char c=str.charAt(length);
            arr[index]=c-48;
            index--;
        }
        return arr;
    }
}
