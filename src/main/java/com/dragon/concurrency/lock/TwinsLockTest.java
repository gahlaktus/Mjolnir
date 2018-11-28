package com.dragon.concurrency.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * 1. 打印线程
 * Worker在两次睡眠之间打印自身线程，如果一个时刻只能有两个线程同时访问，那么打印出来的内容将是成对出现。
 * ​2. 分隔线程
 * 不停的打印换行，能让Worker的输出看起来更加直观。
 * 该测试的结果是在一个时刻，仅有两个线程能够获得到锁，并完成打印，而表象就是打印的内容成对出现。
 * @author huangzhibo
 * @date 04/08/2017
 */
public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();

                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200L);
                    System.out.println("----------分割线----------");
                } catch (Exception e) {
                }
            }
        }).start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
