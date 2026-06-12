package Inetaddress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        //传递完数据之后需要接受数据
        //1.接收数据也需要先创建快递公司
        DatagramSocket ds =new DatagramSocket(10256);   //接收数据的端口必须与传递的端口一致

        //2.接收数据需要书包装,所以创建书包对象
        //还要决定能装多大
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);    //把数组的全部长度都用来装数据
        //receive是阻塞的,会等待发送端发生数据
        ds.receive(dp);

        //4.解析数据
        String str = new String(dp.getData(),0,dp.getLength());
        System.out.println(str);

        //5.释放资源
        ds.close();
    }
}
