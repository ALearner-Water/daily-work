import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread extends Thread {
   Socket sov;

    public MyThread(Socket sov) {
        this.sov = sov;
    }

    @Override
    public void run() {
        //转成字符流可以读取中文
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(sov.getInputStream()));
            String line;
            while ((line = bis.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " 发送了: " + line);
            }
            //回写数据

            //释放资源
            bis.close();
            sov.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("聊天结束");
    }
}
