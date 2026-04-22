import jdk.swing.interop.SwingInterOpUtils;

public class SubStringTest {
    public static void main(String[] args){
        //public String subString(int beginIndex,int endIndex); 有指定范围 包头不包尾
        //public String subString(int beginIndex); 直接到末尾

        String str="we are family";
        //public String subString(int beginIndex,int endIndex);

        String s=str.substring(0,5);    //需要有一个新变量承接返回值
        System.out.println(s);

        System.out.println("----------");

        //public String subString(int beginIndex); 直接到末尾
        String s2=str.substring(5);
        System.out.println(s2);

        //保留第一个字符后面使用***替代
        char s3=str.charAt(0);
        System.out.println(s3+"***");
        str=str.substring(0,1);
        System.out.println(str += "***");
    }
}
