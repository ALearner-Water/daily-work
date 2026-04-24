

public class StringBuilderTest {
    public static void main(String[] args){
        //stringbuilder让拼接字符串效率更高
        //构造方法 1.StringBuilder()  2.StringBuilder(string str)
        //常用成员方法 1.append(...)   2.reverse()  3.int length()   4.toString()
        //创建容器
        StringBuilder sb=new java.lang.StringBuilder(); //并不是一个字符串,只是一个容器
        System.out.println(sb.length());

        //添加数据
        sb.append("aab");
        System.out.println(sb);

        //反转数据
        StringBuilder sb2=sb.reverse();
        System.out.println(sb2);

        //变成字符串
        String sb3=sb.toString();
        System.out.println(sb3);
    }
}
