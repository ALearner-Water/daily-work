package Exercise.work1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
