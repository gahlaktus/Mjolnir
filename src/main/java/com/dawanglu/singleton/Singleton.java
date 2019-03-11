package com.dawanglu.singleton;

/**
 * 双重校验锁
 * @author huangzhibo
 * @date 2019/3/6
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getUniqueInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
