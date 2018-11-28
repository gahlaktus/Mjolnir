package com.dragon.designpattern.singleton;

/**
 * 饿汉式 累出实话的时候实例化instance
 * @author huangzhibo
 * @date 10/10/2017
 */
public class HungerTaskManager1 {

    private static HungerTaskManager1 instance = null;

    private HungerTaskManager1(){}

    static {
        instance = new HungerTaskManager1();
    }

    public static HungerTaskManager1 getInstance() {
        return instance;
    }

}
