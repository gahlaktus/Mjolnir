package com.dragon.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 设计一个同步工具，该工具在同一时刻，只能有两个线程能够并行访问，超过限制的其他线程进入阻塞状态。
 * 注意在任何时候进行状态变更的时候均需要以CAS作为原子性保障
 * @author huangzhibo
 * @date 04/08/2017
 */
public class TwinsLock implements Lock, java.io.Serializable{

    private static final class Sync extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = -7889272986162341211L;

        Sync(int count){
            if (count < 0){
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                System.out.println(newCount);
                if (newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        public boolean tryReleaseShared(int returnCount) {
            // 一定返回true?
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }

    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1) >= 0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
