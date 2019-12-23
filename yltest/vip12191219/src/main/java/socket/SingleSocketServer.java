package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//单播
public class SingleSocketServer {
    public static void main(String[] arg) throws IOException {
        //创建一个服务
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(1234);
            while(true){
                //发送连接等待一个接收请求(该方法是一个阻塞方法)
                Socket socket = serverSocket.accept();
                //lamda表达式创建一个线程方法
                new Thread(()->{
                    try {
                        //读取数据
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        //写数据给客户端
                        PrintWriter writer = new PrintWriter(socket.getOutputStream());
                        //循环打印
                        while (true) {
                            String clientData = reader.readLine();
                            if(clientData ==null){
                                break;
                            }
                            System.out.println("服务器接收到来自客户端的数据："+clientData);
                            //向客户端写数据
                            writer.println("Hello!I am YL");
                            //清空
                            writer.flush();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
}
