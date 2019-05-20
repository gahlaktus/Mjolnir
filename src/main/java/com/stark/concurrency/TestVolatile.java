package com.stark.concurrency;

/**
 * @author zhibohuang
 *
 * volatile 与 println
 *
 * Synchronized内存可见性
 *
 * println()为什么同步？
 */
public class TestVolatile {
 
    private static boolean ready = false;

    private static class CounterThread implements Runnable { 
        @Override 
        public void run() { 
            while (!ready) { 
            } 
            System.out.println(ready); 
        } 
    } 
 
    public static void main(String[] args) { 
        new Thread(new CounterThread()).start(); 
        System.out.println("主线程睡眠300毫秒"); 
        try { 
            Thread.sleep(300); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        ready = true; 
    } 
}