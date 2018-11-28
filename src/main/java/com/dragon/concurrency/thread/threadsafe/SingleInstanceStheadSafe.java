package com.dragon.concurrency.thread.threadsafe;

/**
 * 单例模式（只有一个对象实例存在）线程非安全，非单例线程安全
 * @author huangzhibo
 * @date 07/09/2017
 */
public class SingleInstanceStheadSafe implements Runnable{


    private int instance_i;

    @Override
    public void run() {
        instance_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i 的值:" + instance_i);
        instance_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i*2的值:" + instance_i * 2);
    }

    public static void main(String[] args) {

        SingleInstanceStheadSafe stheadSafe = new SingleInstanceStheadSafe();
        for (int i = 0; i < 3000; i++) {
            new Thread(stheadSafe, "线程"+i).start(); //模拟单例情况
        }
    }
}
