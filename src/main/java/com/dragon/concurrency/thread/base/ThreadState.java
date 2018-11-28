package com.dragon.concurrency.thread.base;

import com.dragon.concurrency.utils.SleepUtils;

/**
 * 线程状态
 * @author huangzhibo
 * @date 18/09/2017
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true)
                SleepUtils.second(100);
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true){
                synchronized(Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }
}
