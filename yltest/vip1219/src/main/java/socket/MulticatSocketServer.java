package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

//组播（服务端）
public class MulticatSocketServer {
    public static void main(String[] args) {
        //创建组（网段范围：224.0.0.0 ~ 239.255.255.255）
        try {
            InetAddress group = InetAddress.getByName("224.1.2.3");
            //创建连接
            MulticastSocket socket = new MulticastSocket();
            //发送消息
            for (int i=0;i<10;i++){
                String data = "Hello!YL!";
                byte[] bytes = data.getBytes();
                //发送UDP消息
                socket.send(new DatagramPacket(bytes,bytes.length,group,6666));
                //休眠两秒
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
