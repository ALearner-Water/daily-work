package Exercise.work1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class demo1 {
    //实现多发多收
    public static void main(String[] args) throws IOException {
        Socket so = new Socket("127.0.0.1", 10020);

        //写数据
        OutputStream op = so.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("exit")) {
                break;
            } else {
                op.write((str+"\n").getBytes());
            }
        }

        //关闭
        so.close();
        op.close();
    }
}
