package Exercise.work1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Serverdemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10020);
        //接收
        InputStreamReader ip = new InputStreamReader(serverSocket.accept().getInputStream());
        //使用缓冲流读取数据会更有效率
        BufferedReader br = new BufferedReader(ip);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        serverSocket.close();
    }
}
