package com.dragon.designpattern.singleton;

import java.io.Serializable;

/**
 * 单例序列化 模板一
 * @author huangzhibo
 * @date 10/10/2017
 */
public class Singleton implements Serializable{

    public static Singleton INSTANCE = new Singleton();

    protected Singleton(){}

    private Object readResolve() {
        return INSTANCE;
    }

}
