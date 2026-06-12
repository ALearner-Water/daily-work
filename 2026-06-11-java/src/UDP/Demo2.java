package UDP;

import java.io.IOException;
import java.net.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //接收数据
        DatagramSocket ds=new DatagramSocket(10088);

        byte[] bys=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bys,bys.length);
        while (true) {
            ds.receive(dp);
            System.out.println("ip地址为 "+dp.getAddress().getHostAddress()
                    +" 主机名称为 "+dp.getAddress().getHostName()+" 内容为: "
                    +new String(dp.getData(),0, dp.getLength()));
        }
    }
}
