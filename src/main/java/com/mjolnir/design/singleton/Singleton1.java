package com.mjolnir.design.singleton;

/**
 * 懒汉式，线程不安全
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1(){}

    /**
     * 当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。
     * @return Singleton1
     */
    public static Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}
