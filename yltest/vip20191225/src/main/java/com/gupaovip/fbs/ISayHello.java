package com.gupaovip.fbs;

import java.rmi.Remote;
import java.rmi.RemoteException;

//创建远程接口
public interface ISayHello  extends Remote {

    public String sayHello(String name) throws RemoteException;
}
