package StringDemo;

public class Test1 {
    public static void main(String[] args){
        /*
            String赋值方法
           1. 直接赋值 String name="aaaa";
           2. new关键字
                        public String()                 空白字符串，无任何内容。
                        public String(String name)      根据传入字符串，创造新字符串对象
                        public String(char[] sc)        传入字符数组，创建字符串对象
                        public String(byte[] be)        根据字节数组，创建字符串对象
         */

        //1. 直接赋值 String name="aaaa";
        String name1="hyh";
        System.out.println(name1);

        //2. new关键字: public String() 空白字符串，无任何内容。
        String name2=new String();
        System.out.println("qqq"+name2+"ppp");  //会输出空字符""

        //3.  public String(String name) 根据传入字符串，创造新字符串对象。
        String name3=new String(name1);
        System.out.println(name3);

        //4.  public String(char[] sc)  传入字符数组，创建字符串对象
        char[] a={'a','b'}; //字符是单引号''
        String name4=new String(a);
        System.out.println(name4);


        //5.public String(byte[] be)  根据字节数组，创建字符串对象
        byte[] b={98,99,100,101};   //ASCII码，数字转字符
        String name5=new String(b);
        System.out.println(name5);
    }
}
