import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        //file常见成员方法(创建和删除)

        //1.创建新空文件  f1.createNewFile()
        File f1 = new File("D:\\53507\\c.txt");
        System.out.println(f1.createNewFile());     //这个方法需要抛出异常,返回值是布尔值
    }
}
