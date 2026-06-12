package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        //不断发送数据，形成类似聊天室的效果
        //1.创建发送端
        DatagramSocket ds=new DatagramSocket();
        //2.准备数据
        Scanner sc=new Scanner(System.in);
        while (true) {
            String str=sc.nextLine();
            if ("886".equals(str)){
                break;
            }
            byte[] bys=str.getBytes();
            //3.打包
            InetAddress ip=InetAddress.getByName("10.18.178.166");      //发送到手机上手机可以接收
            int port=10088;
            DatagramPacket dp=new DatagramPacket(bys,bys.length, ip,10088);
            //4.发送数据
            ds.send(dp);
        }

        //5.释放资源
        ds.close();
    }
}
