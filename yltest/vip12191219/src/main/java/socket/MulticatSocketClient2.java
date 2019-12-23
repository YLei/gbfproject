package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

//组播（客户端）
public class MulticatSocketClient2 {
    public static void main(String[] args) throws UnknownHostException {
        //创建组
        InetAddress group  = InetAddress.getByName("224.1.2.3");
        //创建连接
        try {
            MulticastSocket socket = new MulticastSocket(6666);
            //加到指定组里面
            socket.joinGroup(group);
            byte[] buf = new byte[256];
            while (true){
                DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
                //接收信息
                socket.receive(datagramPacket);
                String msg = new String(datagramPacket.getData());
                System.out.println("接收到的数据："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
