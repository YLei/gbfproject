package com.gupaovip.fbs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//客户端
public class ISayHelloClient {
    public static void main(String[] args) {
        try {
            ISayHello sayHello = (ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(sayHello.sayHello("Hello,XYJ!"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
