package com.mjolnir.design.proxy;

/**
 * 静态代理
 * @author huangzhibo
 * @date 17/01/2018
 */
public class StaticProxiedHello implements Hello {

    private Hello hello = new HelloImpl();

    @Override
    public String sayHello(String content) {
        return hello.sayHello(content);
    }
}
