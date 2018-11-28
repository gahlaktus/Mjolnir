package com.dragon.log.demo0;

import java.lang.reflect.Proxy;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public class MyLoggerTest {

    public static void main(String[] args) {

        BusinessClassService businessClassService = new BusinessClassServiceImpl();

        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessClassService);

        BusinessClassService businessClass = (BusinessClassService) Proxy.newProxyInstance(businessClassService.getClass().getClassLoader(),
                businessClassService.getClass().getInterfaces(), myLoggerHandler);

        businessClass.doSomeThing();
    }
}
