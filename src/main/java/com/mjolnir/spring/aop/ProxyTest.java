package com.mjolnir.spring.aop;

/**
 * @author huangzhibo
 * @date 22/03/2018
 */
public class ProxyTest {

    public static void main(String[] args) {
        Say say1 = new Person("lucy");
        say1 = (Say)JDKDynamicProxy.createProxy(say1);
        say1.sayHi();

        System.out.println("---------------------------------");

        Say say2 = new Animals();
        say2 = (Say)JDKDynamicProxy.createProxy(say2);
        say2.sayHi();
    }

}
