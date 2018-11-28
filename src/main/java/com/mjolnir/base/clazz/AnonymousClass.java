package com.mjolnir.base.clazz;

/**
 *
 * 匿名内部类访问局部变量?
 * lambda
 * @author huangzhibo
 * @date 21/03/2018
 */
public class AnonymousClass {


    public void initListener(String str) {

        final String name = "test";

        new Thread(() -> System.out.println(name));

    }


}
