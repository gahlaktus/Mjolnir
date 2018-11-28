package com.mjolnir.design.singleton;

/**
 * @author huangzhibo
 * @date 21/03/2018
 */
public class Singleton4 {

    /**
     * volatile 的主要原因是其另一个特性：禁止指令重排序优化。
     * 也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。
     */
    private volatile static Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
