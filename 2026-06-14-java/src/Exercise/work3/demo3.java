package Exercise.work3;

import java.io.*;
import java.net.Socket;

public class demo3 {
    //实现传输文件    与file输入输出流结合
    public static void main(String[] args) throws IOException {
        Socket so=new Socket("hyh",10022);
        //先读入文件，用缓冲流包裹
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\53507\\daily-work\\2026-06-14-java\\xx.jpg"));
        //读进来之后就要发送，也是用缓冲流包裹
        BufferedOutputStream bos=new BufferedOutputStream(so.getOutputStream());
        //用byte数组快速读取
        byte [] b=new byte[1024];
        int len;
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len); //读满之后马上写出
        }
        //最写出结束标记
        so.shutdownOutput();

        //接收回写数据
        BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));   //读取字符流并用缓冲流包裹
        System.out.println(br.readLine());

        //释放资源
        so.close();
    }
}
