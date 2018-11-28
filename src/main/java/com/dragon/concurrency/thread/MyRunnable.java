package com.dragon.concurrency.thread;

/**
 * @author huangzhibo
 * @date 01/09/2017
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        methodOne();
    }

    public void methodOne() {

        int localVariable1 = 45;

        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);
    }
}
