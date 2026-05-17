import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class inputDmeo2 {
    //将数据拷贝到目标文件
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\53507\\Desktop\\2023-09-22Augmenting Language Models with Long-Term Memory.pdf");
        FileOutputStream fos = new FileOutputStream("src\\a.pdf");
        int b;
        while((b=fis.read())!=-1){  //调用一次读取一个字节,到达末尾读-1
            fos.write(b);
        }
        //先开的后关
        fos.close();
        fis.close();
    }
}
