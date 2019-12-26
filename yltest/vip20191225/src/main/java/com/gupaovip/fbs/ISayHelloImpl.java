package com.gupaovip.fbs;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//实现远程接口
public class ISayHelloImpl extends UnicastRemoteObject implements ISayHello{

    protected ISayHelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello YL ->"+name;
    }
}
