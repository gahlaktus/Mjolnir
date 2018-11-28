package com.dragon.concurrency.thread.threadsafe;

/**
 * 静态变量非线程安全
 * @author huangzhibo
 * @date 07/09/2017
 */
public class StaticThreadSafe implements Runnable{


    private static int static_i;    // static variable

    @Override
    public void run() {
        static_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i 的值:" + static_i);
        static_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i*2的值:" + static_i * 2);
    }

    public static void main(String[] args) {

        StaticThreadSafe staticThreadSafe = new StaticThreadSafe();

        for (int i = 0; i < 3000; i++) {
            new Thread(staticThreadSafe, "线程"+i).start();
        }
    }
}
