import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class inputDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\53507\\Desktop\\2024-03-24MemoryBank  Enhancing Large Language Models with Long-Term Memory.pdf");
        FileOutputStream fos = new FileOutputStream("src\\a.pdf");
        //使用数组批量读取
        byte[] bytes = new byte[1024*1024*5];
        int a;
        while ((a=fis.read(bytes))!=-1) {   //返回值是读取的字节数
            fos.write(bytes,0,a);   //这里要限定批量读取的字节数
        }
        fos.close();
        fis.close();
    }
}
