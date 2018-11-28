package com.mjolnir.design.singleton;

/**
 * 静态内部类 static nested class
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton6 {

    private static class SingletonHolder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    private Singleton6(){}
    public static final Singleton6 getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
