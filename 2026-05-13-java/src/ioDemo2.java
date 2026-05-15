import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fes=new FileOutputStream("src\\a.txt");
        //一次写一个数组
        byte b[]={97,98,99,100,101};
        fes.write(b);
        //一次写部分数据
        fes.write(b,0,2);
        fes.close();
    }
}
