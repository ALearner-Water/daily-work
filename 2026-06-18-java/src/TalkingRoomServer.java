import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkingRoomServer {
    public static void main(String[] args) throws IOException {
        //接收信息
        ServerSocket sov = new ServerSocket(10012);
        char ch = 'A';  // 创建一个字符变量准备给线程命名
        while (true) {
            Socket so = sov.accept();   // 接收信息
            MyThread t=new MyThread(so);
            t.setName("小" + ch);    //这里就循环给创建的线程命名
            ch++;
            t.start();  // 启动线程
        }
    }
}
