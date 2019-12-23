package socket;

import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] arg){
        try {
            //接收服务器连接
            Socket socketClient = new Socket("localhost",8888);
            //写
            PrintWriter writer = new PrintWriter(socketClient.getOutputStream(),true);
            writer.println("Hello! YLVIP");
            writer.close();
            socketClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
