package com.dragon.designpattern.singleton;

/**
 * 单元素枚举类型实现单例
 * 1. 多线程同步问题;
 * 2. 防止反序列化重新创建新的对象;
 * @author huangzhibo
 * @date 10/10/2017
 */
public enum EnumTaskManager {

    INSTANCE;

    public void doSomething() {
        System.out.println(this + " is speaking!");
    }

}
