import java.util.Scanner;

public class StringAllTest4 {
    public static void main(String[] args) {
        //定义两整数字符串,使他们相加,然后再以字符串形式输出
        //用int直接转有可能字符串会超出限制,所以使用数组,对数组加即可(要考虑进位)

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        //哪个字符串长，数组长度即为长的
        int len = 0;
        if (str2.length() > str1.length()) {
            len = str2.length();
        } else {
            len = str1.length();
        }
        //使用自定义方法把字符拼接成数组 (需要用到ascii2表),48一个循环
        int arr1[]=copydata(str1,len);
        int arr2[]=copydata(str2,len);
        //再定义一个新数组存放计算之后的数,但是数组长度要+1,因为有进位
        int sum[]=new int[len+1];
        //使用循环计算,从个位开始,就是从最大索引开始
        int num=0;  //进位初始化为0
        for (int length = len-1; length >= 0; length--) {   //这个没有考虑最终结果的首位需要自己再加上,因为新数组长度会+1
            int temp=arr1[length]+arr2[length]+num; //结果=数组对应位置数+数组对应位置数+进位
            sum[length+1]=temp%10;   //计算的两个数组的最大位相加之后要变成sum的最大位,sum的长度大1所以要加1
            num=temp/10;    //给下一位做进位用
        }
        //加上首位
        sum[0]=num;
        //调用之前写的拼接字符串方法拼接3个数组
        ArrayCombine.arraycombine(arr1);
        ArrayCombine.arraycombine(arr2);
        ArrayCombine.arraycombine(sum);
        //使用stringbuilder拼接字符串
        StringBuilder sb=new StringBuilder();
        if(sum[0]!=0){
            sb.append(sum[0]);
        }
        for (int i = 1; i < sum.length; i++) {
                sb.append(sum[i]);
        }
        System.out.println(sb.toString());
    }
    //把数据存入数组
    public static int[] copydata(String str, int len) {   //传入字符串和数组长度
        int arr[]=new int[len];
        //从大到小循环遍历存入字符串
        int index=arr.length-1;
        for (int length = str.length()-1; length >= 0; length--) {
            arr[index] = str.charAt(length) -48;
            index--;
        }
        return  arr;
    }
}
