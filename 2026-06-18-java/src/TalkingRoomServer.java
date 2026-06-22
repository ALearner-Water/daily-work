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
        char ch = 'A';
        while (true) {
            Socket so = sov.accept();
            MyThread t=new MyThread(so);
            t.setName("小" + ch);
            ch++;
            t.start();
        }
    }
}
