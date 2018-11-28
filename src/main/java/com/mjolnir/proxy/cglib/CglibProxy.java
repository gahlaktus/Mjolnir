package com.mjolnir.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib有两种可选方式，继承和引用。
 * 第一种是基于继承实现的动态代理，所以可以直接通过super调用target方法，但是这种方式在spring中是不支持的，因为这样的话，这个target对象就不能被spring所管理.
 * 所以cglib还是采用类似jdk的方式，通过持有target对象来达到拦截方法的效果。
 * @author huangzhibo
 * @date 2018/8/27
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 第一个参数是代理对像，第二和第三个参数分别是拦截的方法和方法的参数。
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        System.out.println(method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        return o1;
    }
}
