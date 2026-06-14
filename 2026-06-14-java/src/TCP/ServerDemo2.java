package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //接收数据
        ServerSocket sv = new ServerSocket(10086);

        InputStream inputStream = sv.accept().getInputStream();//只能读字节流文件不可以读中文
        //要转成字符流
        InputStreamReader reader = new InputStreamReader(inputStream);
        //可以一步到位
        //InputStreamReader reader = new InputStreamReader(sv.accept().getInputStream());
        int b;
        while ((b = reader.read()) != -1){  //直接用字符流来读
            System.out.print((char) b);
        }

    }
}
