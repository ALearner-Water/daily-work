import java.io.File;

public class FileDemo6 {
    public static void main(String[] args){
        //写一个方法看看是否存在这个文件
        File f=new File("D:\\53507");   //f的路径
        System.out.println(isexict(f));     //非静态方法不能中静态方法里面被调用
    }
    public static boolean isexict(File file){
        //获取文件里面的所有文件并返回数组
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()&&file1.getName().endsWith("txt")){
                return true;
            }
        }
        return false;
    }
}
