package main.java.com.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huangzhibo
 * @date 25/08/2017
 */
public class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object t){
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(target);

        System.out.println("method name: "+ method.getName()+"parameters: " + args);

        return method.invoke(target, args);
    }
}
