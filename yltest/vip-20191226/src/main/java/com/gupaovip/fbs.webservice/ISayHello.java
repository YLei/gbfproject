package com.gupaovip.fbs.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

@WebService
public interface SayHello {
    @WebMethod
    public String sayHello(String name) throws RemoteException;
}
