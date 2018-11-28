package com.mjolnir.learn;

/**
 * @author huangzhibo
 * @date 19/04/2018
 */
public class DoubleCheckedLocking {

    private static Instance instance;

    public static Instance getInstance(){

        // 第一次检查
        if (instance == null){
            // 加锁
            synchronized(DoubleCheckedLocking.class){
                // 第二次检查
                if (instance == null){
                    // 此处有问题
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}
