import java.io.FileOutputStream;
import java.io.IOException;

public class ioDemo4 {
    public static void main(String[] args) throws IOException {
        //续写的话只要打开续写开关即可
        FileOutputStream fes=new FileOutputStream("src\\a.txt",true);
        String s="ssssssss";
        byte[] bytes = s.getBytes();
        fes.write(bytes);
        String s1="\r\n";
        fes.write("我喜欢你".getBytes());
        fes.close();
    }
}
