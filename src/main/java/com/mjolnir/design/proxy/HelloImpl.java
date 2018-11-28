package com.mjolnir.design.proxy;

/**
 * @author huangzhibo
 * @date 17/01/2018
 */
public class HelloImpl implements Hello{

    @Override
    public String sayHello(String content) {
        return "HelloImpl: " + content;
    }
}
