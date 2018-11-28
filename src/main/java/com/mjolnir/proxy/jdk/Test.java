package com.mjolnir.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author huangzhibo
 * @date 2018/8/27
 */
public class Test {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));


        // dynamic proxy using a lambda expression
        UserService lambdaCase = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), userService.getClass().getInterfaces(), ((proxy, method, args1) -> {
            // start time
            long startTime = System.nanoTime();

            Object result = method.invoke(userService, args1);
            System.out.println("Executed method " + method.getName()
                    + " in " + (System.nanoTime() - startTime)
                    + " nanoseconds.");

            return result;
        }));

        lambdaCase.getName(1);

        // test DynamicInvocationHandler

        Map proxyInstance = (Map) Proxy.newProxyInstance(DynamicInvocationHandler.class.getClassLoader(), new Class[]{Map.class}, new DynamicInvocationHandler());
        proxyInstance.put("hello", "world");

        Map proxyInstance1 = (Map) Proxy.newProxyInstance(DynamicInvocationHandler.class.getClassLoader(), new Class[]{Map.class}, ((proxy, method, args1) -> {
            if (method.getName().equals("get")){
                return 42;
            } else {
                throw new UnsupportedOperationException("Unsupported method: " + method.getName());
            }
        }));

        System.out.println((int)proxyInstance1.get("hello"));
        proxyInstance1.put("hello", "world");

    }

}
