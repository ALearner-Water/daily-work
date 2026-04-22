public class OrtherTest {
    /* contains  是否包含
        startsWish/endWish 判断开头结尾
        indexOf(int a)  lastIntdexOf(int a) 查找
        isEmpety()  判断是否空
        toCharArray()   转字符数组
        toUpperCase/toLowerCase 大小写转换
        trim()  去除首尾空格
     */
    public static void main(String[] args) {
        //contains  是否包含
        String str = "hello";
        boolean b=str.contains("el");   //是布尔类型
        System.out.println(b);

        //startsWish/endWish 判断开头结尾
        boolean c=str.startsWith("e");  //也是布尔类型
        boolean d=str.endsWith("ll");
        System.out.println(c);
        System.out.println(d);

        //indexOf(int a)  lastIntdexOf(int a) 查找
        System.out.println(str.indexOf("l"));   //只会输出最先找到的那个
        System.out.println(str.lastIndexOf("l"));   //找最后出现的那个

        //isEmpety()  判断是否空 在做登录界面时
        boolean e=str.isEmpty();
        System.out.println(e);
        String k="";
        System.out.println(k.isEmpty());

        //toCharArray()   转字符数组  将字符串改写为数组
        char arr[]=str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //toUpperCase/toLowerCase 大小写转换
        System.out.println(str.toUpperCase());

        //trim()  去除首尾空格
        String a=" a  b c d    ";   //只能去首尾
        System.out.println(a.trim());
    }
}
