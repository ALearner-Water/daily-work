import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioDemo3 {
    public static void main(String[] args) throws IOException {
        //想要写很多数据,则把数据写成字符串再转成byte数组即可
        FileOutputStream fes = new FileOutputStream("src\\a.txt");
        String s = "abcdefgh";
        byte[] bytes = s.getBytes();      //将字符串转成byte数组
        fes.write(bytes);
        //换行    window换行\r\n
        String s1 = "\r\n";
        byte[] byte1 = s1.getBytes();
        fes.write(byte1);
        fes.write(98);
        fes.close();
    }
}
