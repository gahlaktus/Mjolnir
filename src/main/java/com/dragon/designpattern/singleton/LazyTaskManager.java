package com.dragon.designpattern.singleton;

/**
 * 懒汉式 构造单例
 * 双重校验锁
 * @author huangzhibo
 * @date 20/06/2017
 */
public class LazyTaskManager {

    private static LazyTaskManager instance = null;

    //private volatile static LazyTaskManager instance;

    private LazyTaskManager(){}

    public static LazyTaskManager getInstance(){
        if (null == instance){
            synchronized (LazyTaskManager.class){
                if (null == instance){
                    instance = new LazyTaskManager();
                }
            }
        }
        return instance;
    }
}
