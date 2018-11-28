package com.mjolnir.rpcexplore.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author huangzhibo
 * @date 16/03/2018
 */
public class ServerMain {

    public static void main(String[] args) throws Exception{

        HelloService helloService = new HelloServiceImpl();

        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("ServerMain provide RPC service now");

    }

}
