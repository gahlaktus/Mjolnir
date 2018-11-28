package com.dragon.concurrency.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic 原子操作例子
 * @author huangzhibo
 * @date 04/09/2017
 */
public class AtomicCountTest {


    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {

        final AtomicCountTest cas = new AtomicCountTest();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j <10000; j++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for (;;){
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc){
                break;
            }
        }
    }
    private void count() {
        i++;
    }
}
