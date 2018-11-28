package com.dragon.designpattern.singleton;

/**
 * 静态内部类 构造单例
 * @author huangzhibo
 * @date 20/06/2017
 */
public class IODHTaskManager {

    private IODHTaskManager(){}

    private static class HoldClass {
        private static final IODHTaskManager instance = new IODHTaskManager();
    }

    public static IODHTaskManager getInstance(){
        return HoldClass.instance;
    }
}
