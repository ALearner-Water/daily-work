package Exercise.work4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Serverdemo4 {
    //服务端           想要服务器不停止，接收很多用户上传的文件  使用多线程加循环

    public static void main(String[] args) throws IOException {

        ServerSocket svo = new ServerSocket(11101);
        while (true) {  //使用循环，让服务器不关闭，且不断接收用户上传的文件
            Socket accept = svo.accept();
            //使用多线程的形式
            new MyThread(accept).start();
        }
    }
}
