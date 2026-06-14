package Exercise.work1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Serverdemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10020);
        //接收
        while (true) {
            InputStreamReader ip=new InputStreamReader(serverSocket.accept().getInputStream());
            //使用缓冲流读取数据会更有效率
            BufferedReader br=new BufferedReader(ip);
            System.out.println(new String(br.readLine()));
            System.out.println();

        }
    }
}
