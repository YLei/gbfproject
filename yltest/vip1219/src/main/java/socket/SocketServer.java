package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] arg) throws IOException {
        ServerSocket socketServer = null;
        try {
            //启动一个服务
            socketServer = new ServerSocket(8888);
            //等待一个接收请求
            Socket socket = socketServer.accept();
            //缓冲读流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            socketServer.close();
        }
    }

}
