package com.mjolnir.proxy.cglib;

import com.mjolnir.proxy.jdk.UserService;
import com.mjolnir.proxy.jdk.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author huangzhibo
 * @date 2018/8/27
 */
public class Test {

    public static void main(String[] args) {

        /**
         *  net.sf.cglib.proxy.Enhancer – 主要的增强类
         *  net.sf.cglib.proxy.MethodInterceptor – 主要的方法拦截类，它是Callback接口的子接口，需要用户实现
         *  net.sf.cglib.proxy.MethodProxy – JDK的java.lang.reflect.Method类的代理类，可以方便的实现对源对象方法的调用,如使用：
         *  Object o = methodProxy.invokeSuper(proxy, args);    //虽然第一个参数是被代理对象，也不会出现死循环的问题。
         */

        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService) enhancer.create();
        o.getName(1);
        o.getAge(1);

    }

}
