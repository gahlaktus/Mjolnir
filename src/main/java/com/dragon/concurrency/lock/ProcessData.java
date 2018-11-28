package com.dragon.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 处理数据时采用锁降级，保证数据可见性。
 * 读锁的机制：AQS共享锁；
 * 写锁的机制：AQS独占锁。
 *
 * 使用场景：缓存并发一致性，读多写少的场景
 * @author huangzhibo
 * @date 14/09/2017
 */
public class ProcessData {

    /*
    * ReentrantReadWriteLock() 读写锁
    * 特性：
    *   1. 公平性（公平锁 || 非公平锁）
    *   2. 重进入（读线程：能再获取读锁；写线程：再次获取写锁或者读锁）
    *   3. 锁降级（写锁降级为读锁）
    *  分析点：
    *   读写状态的设计
    *   写锁的获取与释放
    *   读锁的获取与释放
    *   锁降级
    * */
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock readLock = rwl.readLock();
    private static final Lock writeLock = rwl.writeLock();
    private volatile boolean update = false;

    public void processData() {
        readLock.lock();
        if (!update) {
            readLock.unlock();
            // 先将读锁释放掉，才能获取写锁.
            writeLock.lock();
            try {
                if (!update){
                    // ...  进行写操作
                    update = true;
                }
                readLock.lock();    //获取读锁, 防止其他写锁进来.保证数据的可见性，如果当前线程不获取读锁而是直接释放写锁,可能会出现另一线程T获取了写锁并进行修改数据
            } finally {
                writeLock.unlock();  //降级
            }
            // 锁降级完成，写锁降级为读锁
        }
        try {
            //... 进行读操作
        } finally {
            readLock.unlock();
        }
    }

}
