package com.mjolnir.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @author huangzhibo
 * @date 17/01/2018
 */
public class TestHello {

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(TestHello.class.getClassLoader(), new Class<?>[]{Hello.class}, new LogInvocationHandler(new HelloImpl()));
        System.out.println(hello.sayHello("This is a test case"));
    }

}
