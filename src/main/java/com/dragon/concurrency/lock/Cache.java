package com.dragon.concurrency.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;
/**
 * 读写锁实现HashMap读写安全
 * 提升读操作的并发性，保证每次写操作对所有的读写操作的可见性。
 * hashMap 实现缓存
 *
 * @author huangzhibo
 * @date 14/09/2017
 */
public class Cache {

    private static final Map<String, Object> map = new HashMap<>();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock r = rwl.readLock();
    private static final Lock w = rwl.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value){
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
