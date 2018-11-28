package com.dragon.concurrency.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author huangzhibo
 * @date 18/09/2017
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){

        }
    }

}
