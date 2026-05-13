import java.io.File;
import java.io.IOException;

public class FileDemo5 {
    //需要创建一个文件夹在文件夹里面创建一个新文件
    public static void main(String[] args) throws IOException {
        //1.先创建对象
        File s=new File("src\\aaa");
        //再创建文件夹使用是s.mkdirs
        s.mkdirs(); //没有路径就会创造路径
        //再创建文件
        File f=new File(s,"bbb.py");
        f.createNewFile();
    }
}

