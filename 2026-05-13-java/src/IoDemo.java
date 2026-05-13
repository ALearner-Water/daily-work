import java.io.*;

public class IoDemo {
    public static void main(String[] args) throws IOException {
        //创建输出流对象并写入数据(若对象不存在且父级路径存在,可以自动创建新文件)
        FileOutputStream str=new FileOutputStream("src\\aaa");    //outputstream是抽象类只能用子类来创建对象
        str.write(97);  //这个是输入ascii码
        str.close();    //写完要关闭通道
    }
}
