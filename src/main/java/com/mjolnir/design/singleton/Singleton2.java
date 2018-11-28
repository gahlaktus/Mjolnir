package com.mjolnir.design.singleton;

/**
 * 懒汉式，线程安全
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    /**
     * 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
     * 因为在任何时候只能有一个线程调用 getInstance() 方法。
     * 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。
     * @return Singleton2
     */
    public static synchronized Singleton2 getInstance() {
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
