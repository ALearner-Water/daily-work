package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Demo1 {
    //TCP发送数据
    public static void main(String[] args) throws IOException {
        //先创建发送数据的Socket对象
        Socket socket = new Socket("hyh", 10086); //如果连接不上就会报错

        //创建输出流，发送数据
        OutputStream out= socket.getOutputStream();
        out.write("你好".getBytes()); //要转成字节数组

        //关闭流和Socket
        out.close();
        socket.close();
    }
}
