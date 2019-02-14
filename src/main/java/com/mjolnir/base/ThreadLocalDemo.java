package com.mjolnir.base;

import java.util.concurrent.CountDownLatch;

/**
 * ThreadLocal 并不解决线程间共享数据的问题
 * ThreadLocal 通过隐式的在不同线程内创建独立实例副本避免了实例线程安全的问题
 * 每个线程持有一个 Map 并维护了 ThreadLocal 对象与具体实例的映射，该 Map 由于只被持有它的线程访问，故不存在线程安全以及锁的问题
 * ThreadLocalMap 的 Entry 对 ThreadLocal 的引用为弱引用，避免了 ThreadLocal 对象无法被回收的问题
 * ThreadLocalMap 的 set 方法通过调用 replaceStaleEntry 方法回收键为 null 的 Entry 对象的值（即为具体实例）以及 Entry 对象本身从而防止内存泄漏
 * ThreadLocal 适用于变量在线程间隔离且在方法间共享的场景
 *
 * 线程间隔离、方法间共享，低耦合。
 *
 * 三个线程通过ThreadLocal的get()方法获取的是不同的StringBuilder实例，但每个线程所访问到的是同一个ThreadLocal变量。
 *
 * ThreadLocal简单描述：ThreadLocal维护一个Map，每个线程对应一个实例映射，线程无效时，应该清除该映射。
 * 新增或者减少线程的时候都需要对map进行读写，因此需要保证该map线程安全。
 * 线程结束的时候需要保证它所访问的所有的ThreadLocal中对应的映射均删除，否则会引起内存泄漏！（如何保证并避免内心泄露？）
 *
 * @author huangzhibo
 * @date 2018/12/25
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        int threads = 3;
        CountDownLatch latch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 1; i <= threads; i++) {

            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("Hello World");
                latch.countDown();
            }, "thread - " + i).start();
        }
        latch.await();
    }

    private static class InnerClass {
        public void add(String newStr){
            StringBuilder sb = Counter.counter.get();
            Counter.counter.set(sb.append(newStr));
        }

        public void print(){
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s , Instance hashcode:%s, Value:%s",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
            System.out.println();
        }
        public void set(String words){
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s , Instance hashcode:%s, Value:%s",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
            System.out.println();
        }
    }

    private static class Counter{
        private static ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(StringBuilder::new);
    }

}
