package Inetaddress;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    //internetAddress getByName()   //获取指定主机的ip,可以是机器名称（hyh）、ip地址
    public static void main(String[] args) throws UnknownHostException {
        //创建对象
        InetAddress address = InetAddress.getByName("hyh");
        System.out.println(address);
        //可以使用方法
        String hostAddress = address.getHostAddress();  //获取ip
        System.out.println(hostAddress);
        String hostName = address.getHostName();
        System.out.println(hostName);
    }

}
