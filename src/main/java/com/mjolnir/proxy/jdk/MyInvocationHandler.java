package com.mjolnir.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huangzhibo
 * @date 2018/8/27
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(){
        super();
    }

    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("getName".equals(method.getName())){
            // do something before invoke this method.
            System.out.println("++++++before " + method.getName() + "++++++");
            Object result = method.invoke(target, args);
            // do something after invoke this method.
            System.out.println("++++++after " + method.getName() + "++++++");
            return result;

        }else{
            return method.invoke(target, args);
        }
    }
}
