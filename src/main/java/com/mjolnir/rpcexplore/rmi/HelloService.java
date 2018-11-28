package com.mjolnir.rpcexplore.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI对外服务的接口
 * @author huangzhibo
 * @date 16/03/2018
 */
public interface HelloService extends Remote{

    String sayHello(String str) throws RemoteException;

}
