package com.dragon.concurrency.thread.threadsafe;

/**
 * @author huangzhibo
 * @date 19/10/2017
 */
public class InterruptedThread {


    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true){
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

}
