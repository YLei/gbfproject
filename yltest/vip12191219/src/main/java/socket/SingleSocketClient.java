package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SingleSocketClient {

    public static void main(String[] arg){
        try {
            while (true){
                //与服务器建立连接
                Socket socket = new Socket("localhost",1234);
                //写数据
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
                //读取服务器发送来的消息
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer.println("Hello!I am XYJ");
                while (true){
                    String serverData = reader.readLine();
                    if(serverData == null){
                        break;
                    }
                    System.out.println("客户端收到服务器发送的消息："+serverData);
                }
                writer.close();
                socket.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
