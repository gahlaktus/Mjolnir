package com.dragon.concurrency.thread;

import com.dragon.concurrency.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author huangzhibo
 * @date 18/09/2017
 */
public class Interrupted {

    public static void main(String[] args) throws Exception{

        Thread sleepThread = new Thread(new SleepRunner(), "SleepRunner");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        SleepUtils.second(2);

    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true)
                SleepUtils.second(10);
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true){

            }
        }
    }

}
