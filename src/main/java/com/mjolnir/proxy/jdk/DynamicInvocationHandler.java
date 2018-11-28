package com.mjolnir.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author huangzhibo
 * @date 2018/8/28
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private static Logger LOG = Logger.getLogger(DynamicInvocationHandler.class.getName());

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        LOG.info("Invoked method: "+method.getName());
        return 42;
    }
}
