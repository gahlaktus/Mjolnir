package com.mjolnir.learn;

/**
 * @author huangzhibo
 * @date 19/04/2018
 */
public class SafeDoubleCheckedLocking {

    private volatile static Instance instance;

    public static Instance getInstance(){
        if (instance == null){
            synchronized (SafeDoubleCheckedLocking.class){
                if (instance == null){
                    // 本质上是通过禁止 new Instance() 是重排序来实现的。
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}
