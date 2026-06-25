import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    Socket sov;  // 保存当前用户
    private static List<MyThread> clients = new ArrayList<>();   // 保存所有在线用户

    public MyThread(Socket sov) {
        this.sov = sov;
    }   // 构造方法

    @Override
    public void run() {
        //转成字符流可以读取中文
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(sov.getInputStream()));
            synchronized (clients) {     // 同步代码块用来锁定clients,可以阻止并发
                clients.add(this);      // 将当前用户添加到在线用户列表
            }
            String line;
            while ((line = bis.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " 发送了: " + line);
                SendmessAage(line);      // 遍历发送信息(抽取出方法更容易修改)
            }
            synchronized (clients) {     // 同步代码块用来锁定clients,可以阻止并发
                clients.remove(this);      // 将当前用户从在线用户列表中移除
            }
            //释放资源
            bis.close();
            sov.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("聊天结束");
    }
    private void SendmessAage(String message) throws IOException {
        //开始遍历列表将信息发送出去
        synchronized (clients){
            for(MyThread t:clients){    // 遍历列表创建缓冲流发送信息
                BufferedWriter bos=new BufferedWriter(new OutputStreamWriter(t.sov.getOutputStream(),"UTF-8"));
                bos.write(message+"\n");    // 写出数据
                bos.flush();    // 立即发送
            }
        }
    }
}


