package com.dragon.concurrency.practise;

/**
 * @author huangzhibo
 * @date 2018/11/28
 */
public class SyncWaitNotifyDemo {

    public static void main(String[] args) {

        SyncObj syncObj = new SyncObj();

        Thread threadA = new Thread(new PrintLetterRunnable(syncObj, 'A'));
        Thread threadB = new Thread(new PrintLetterRunnable(syncObj, 'B'));
        Thread threadC = new Thread(new PrintLetterRunnable(syncObj, 'C'));

        threadA.start();
        threadB.start();
        threadC.start();

    }

}
