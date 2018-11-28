package com.dragon.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public class LogProxy implements InvocationHandler{

    /**
     * 日志代理类
     */
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Object delegate;

    public Object bind(Object delegate){
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        try {
            logger.log(Level.INFO, args[0] +"开始订票!");
            result = method.invoke(this.delegate, args);
            logger.log(Level.INFO, args[0] +"订票结束!");
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
        }
        return result;
    }
}
