package com.dragon.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界缓存实现
 * @author huangzhibo
 * @date 13/09/2017
 */
public class BoundedBuffer {

    private final Lock lock = new ReentrantLock();  //default non-fair

    // condition 依赖于lock来产生
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];

    private int putstr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();

            items[putstr] = x;
            if (++putstr == items.length) putstr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
