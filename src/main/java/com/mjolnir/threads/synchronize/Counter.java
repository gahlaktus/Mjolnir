package com.mjolnir.threads.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangzhibo
 * @date 03/04/2018
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    private void safeCount(){
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc){
                break;
            }
        }
    }

    private void count(){
        i++;
    }

    public static void main(String[] args) {

        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }
        for (Thread t : ts){
            t.start();
        }
        for (Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);

    }
}
