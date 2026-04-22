public class ReplaceTest {
    public static void main(String[] args){
        //String replace(旧值,新值)

        String str="你好,TMD";
        String s1=str.replace("TMD","***");   //需要有新变量接住返回值
        System.out.println(s1);


        //模仿现实替换敏感词
        //首先要用敏感词库
        String arr[]={"TMD","WC","CMD"};
        String s2="你好，TMDWCCMD";
        //循环遍历数据库
        for (int i = 0; i < arr.length; i++) {
            s2=s2.replace(arr[i],"***");
        }
        System.out.println(s2);
    }
}
