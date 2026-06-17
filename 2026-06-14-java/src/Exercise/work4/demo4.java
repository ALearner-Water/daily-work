package Exercise.work4;

import java.io.*;
import java.net.Socket;

public class demo4 {
    public static void main(String[] args) throws IOException {
        //想要服务器不停止，接收很多上传的文件  使用多线程加循环

        Socket so=new Socket("hyh",11101);
        //读入文件  使用缓冲流包裹
        BufferedInputStream bus=new BufferedInputStream(new FileInputStream("D:\\53507\\daily-work\\2026-06-14-java\\xx.jpg"));
        //写出数据
        BufferedOutputStream bos=new BufferedOutputStream(so.getOutputStream());
        byte [] b=new byte[1024];
        int len;
        while ((len=bus.read(b))!=-1){
            bos.write(b,0,len);
        }
        //写结束标记
        so.shutdownOutput();

        //接收回写数据
        BufferedReader bu=new BufferedReader(new InputStreamReader(so.getInputStream()));
        System.out.println(bu.readLine());

        so.close();
    }
}
