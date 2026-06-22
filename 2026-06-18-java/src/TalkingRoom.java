import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TalkingRoom {
    public static void main(String[] args) throws IOException {
        //使用多线程实现聊天室功能,先要写服务端
        Socket so = new Socket("hyh", 10012);
        //使用缓冲流包裹
        BufferedOutputStream buf = new BufferedOutputStream(so.getOutputStream());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入信息:");
            String str = sc.nextLine();
            if (str.equals("拜拜")) {
                break;
            } else {
                buf.write((str + "\n").getBytes());
                buf.flush();
            }
        }

        //释放资源
        buf.close();
        so.close();
        sc.close();
    }
}
