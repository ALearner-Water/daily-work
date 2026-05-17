import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class inputDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\aaa.txt");
        int read;
        while ((read = fis.read()) != -1) {  //调用一次读取一个字节,到达末尾读-1
            System.out.print((char) read);
        }
        fis.close();
    }
}

