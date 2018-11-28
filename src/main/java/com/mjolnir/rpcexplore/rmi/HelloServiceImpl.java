package com.mjolnir.rpcexplore.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 服务端RMI接口实现
 * 必须继承UnicastRemoteObject类
 * @author huangzhibo
 * @date 16/03/2018
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService{

    private static final long serialVersionUID = -6190513770400890033L;

    public HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String str) throws RemoteException {
        return "Hello, " + str;
    }
}
