package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        //接收数据,第一需要创建serversocket对象
        ServerSocket serverSocket = new ServerSocket(10086);    //接收是serversocket

        //监听客户端连接   会死等客户端
        Socket accept = serverSocket.accept();  //会返回socket对象

        //通过对象获取输入流，接收数据
        InputStream inputStream = accept.getInputStream();
        //写循环读数据
        int b;
        while ((b = inputStream.read()) != -1) {    //转中文会乱码，必须转成字符流读
            System.out.println((char) b);
        }

        //关闭流和Socket
        inputStream.close();
        accept.close();

    }
}
