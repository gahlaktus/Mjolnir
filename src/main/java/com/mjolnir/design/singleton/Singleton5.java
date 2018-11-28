package com.mjolnir.design.singleton;

/**
 * 饿汉式 static final field
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton5 {

    private static final Singleton5 instance = new Singleton5();

    private Singleton5(){}

    public static Singleton5 getInstance() {
        return instance;
    }

}
