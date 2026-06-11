package Inetaddress;

import java.io.IOException;
import java.net.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //使用UDP协议发送数据
        //1.创建对象(快递公司)
        DatagramSocket ds = new DatagramSocket(); //有参就是绑定端口

        //2.打包数据(将数据打包，不可以散着发)
        String str = "你好";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("hyh");
        int port = 10256;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port); //需要有传输的信息(已字节数组的形式传输) 还要指定长度  还要指定地址和端口

        //3.发送数据
        ds.send(dp);

        //4.释放资源
        ds.close();
    }
}
