import java.io.File;

public class FileDemo1 {
    public static void main(String[] args){
        //C:\Users\53507\Desktop\上传步骤.txt

        //根据路径生成file对象
        String str="C:\\Users\\53507\\Desktop\\上传步骤.txt";
        File file=new File(str);    //绝对路径带盘符
        System.out.println(file);   //相对路径不带盘符
    }
}
