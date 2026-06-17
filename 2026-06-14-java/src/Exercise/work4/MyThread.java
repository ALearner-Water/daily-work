package Exercise.work4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyThread extends Thread {
    //发现粘贴进来没有socket对象 accept所以需要使用构造方法传递
    Socket accept;

    public MyThread(Socket socket) {
        this.accept = socket;
    }

    @Override
    public void run() {
        try {
            //使用缓冲流读入数据
            BufferedInputStream bis=new BufferedInputStream(accept.getInputStream());
            //使用缓冲流写出数据到新的文件夹
            String replace = UUID.randomUUID().toString().replace("-", "");
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\53507\\daily-work\\2026-06-14-java\\picture\\"+replace+".jpg"));
            byte [] b=new byte[1024];
            int len;
            while ((len=bis.read(b))!=-1){
                bos.write(b,0,len);
            }
            //再回写数据,使用bufferedWriter直接写出
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("接收成功");
            //释放资源+刷新  要实现服务器关闭，不能写close
            bw.flush();
            bis.close();
            bos.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (accept!=null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
