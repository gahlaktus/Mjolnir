package com.dragon.concurrency.thread.threadsafe;

/**
 * Created by huangzhibo on 19/05/2017.
 */
public class MyCounter {

    /**
     * the method getCount() is not thread safe, because of ++ operation,
     * ++ operation include: accessing value and increasing value; ++ operation is not atomic.
     */
    private static int counter = 0;

    public static int getCount(){
        return counter++;
    }

    /**
     * two way to improve the method thread safe:
     * 1. use synchronized;     check MyCounter1.java
     * 2. use AtomicInteger.    check MyCounter2.java
     */
}
