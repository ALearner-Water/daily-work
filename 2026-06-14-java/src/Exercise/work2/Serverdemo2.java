package Exercise.work2;

import Exercise.work1.Serverdemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket sv=new ServerSocket(10011);
        Socket accept = sv.accept();
        BufferedReader bf=new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        while((line=bf.readLine())!=null){
            System.out.println(line);
        }


        //数据回传
        OutputStream op=accept.getOutputStream();
        op.write("欢迎你".getBytes());

        //释放资源
        bf.close();
        accept.close();

    }
}
