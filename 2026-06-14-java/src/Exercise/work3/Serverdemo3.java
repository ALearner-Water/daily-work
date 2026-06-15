package Exercise.work3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo3 {
    public static void main(String[] args) throws IOException {
        //接收数据
        ServerSocket so=new ServerSocket(10022);
        Socket accept = so.accept();    //接收数据
        //读入数据然后再存入新文件夹,也是用缓冲流包裹
        BufferedInputStream bis=new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\53507\\daily-work\\2026-06-14-java\\picture\\a.jpg"));
        byte [] b=new byte[1024];
        int len;
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }

        //再回写数据
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("接收成功");
        bw.flush();

        so.close();
        bis.close();
        bos.close();
    }
}
