package com.dawanglu.jvmdemo;

/**
 * @author huangzhibo
 * @date 2019/4/1
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }
    // 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
    public static final String HELLOWORLD = "hello world";
}
