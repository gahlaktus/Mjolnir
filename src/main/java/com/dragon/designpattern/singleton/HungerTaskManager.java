package com.dragon.designpattern.singleton;

/**
 *
 * 饿汉式 构造单例
 * @author huangzhibo
 * @date 20/06/2017
 */
public class HungerTaskManager {

    private static final HungerTaskManager instance= new HungerTaskManager();

    private HungerTaskManager(){}

    public static HungerTaskManager getInstance(){
        return instance;
    }
}
