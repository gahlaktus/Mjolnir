package com.stark.beautifulconcur;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhibo
 * @date 2019/6/19
 */
public class TestSleep {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread tA = new Thread(() -> {

            lock.lock();

            try {
                System.out.println("child tA is in sleep");
                Thread.sleep(10000);
                System.out.println("child tA is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });

        Thread tB = new Thread(() -> {

            lock.lock();
            try {
                System.out.println("child tB is in sleep");
                Thread.sleep(10000);
                System.out.println("child tB is in awaked");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        tA.start();
        tB.start();
    }

}
