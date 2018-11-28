package com.dragon.concurrency.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * 公平锁与非公平锁测试
 *
 * 所谓的公平与非公平在于是否要排队！
 *
 * @author huangzhibo
 * @date 14/09/2017
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    private static CountDownLatch start;

    @Test
    public void unfair(){
        testLock(unfairLock);
    }

    @Test
    public void fair() {
        testLock(fairLock);
    }
    private void testLock(Lock lock){
        start = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock);
            thread.setName("td-"+i);
            thread.start();
        }
        start.countDown();
    }

    private static class Job extends Thread {
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try{
                start.await();
            } catch (InterruptedException e){

            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by [" + getName() + "], Waiting by " + ((ReentrantLock2) lock).getQueuedThreads());
                } finally {
                    lock.unlock();
                }
            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }
    private static final class ReentrantLock2 extends ReentrantLock {
        private static final long serialVersionUID = -6736727496956351588L;
        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {

            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

}
