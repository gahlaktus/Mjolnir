package com.mjolnir.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * JDK动态代理
 * @author huangzhibo
 * @date 17/01/2018
 */
public class LogInvocationHandler implements InvocationHandler {

    private Hello hello;

    public LogInvocationHandler(Hello hello){
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sayHello".equals(method.getName())){
            System.out.println("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }
}
