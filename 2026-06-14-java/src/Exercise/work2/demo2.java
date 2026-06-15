package Exercise.work2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class demo2 {
    //实现数据的输出与回传
    public static void main(String[] args) throws IOException {
        Socket so=new Socket("hyh",10011);
        String str="你好我想你";
        so.getOutputStream().write(str.getBytes());
        so.shutdownOutput();    //不停止服务端会阻塞

        //接收回传数据
        InputStream inputStream = so.getInputStream();
        InputStreamReader ips=new InputStreamReader(inputStream);
        int b;
        while ((b=ips.read())!=-1){
            System.out.print((char) b);
        }
        //释放资源
        so.close();
    }
}
