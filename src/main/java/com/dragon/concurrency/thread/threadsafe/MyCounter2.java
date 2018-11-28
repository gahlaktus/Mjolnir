package com.dragon.concurrency.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huangzhibo on 19/05/2017.
 */
public class MyCounter2 {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static int getCount(){
        return counter.getAndIncrement();
    }

}
