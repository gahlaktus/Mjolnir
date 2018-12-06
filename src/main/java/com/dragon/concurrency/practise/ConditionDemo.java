package com.dragon.concurrency.practise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhibo
 * @date 2018/11/28
 */
public class ConditionDemo {

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private char currentThreadName = 'A';

    public static void main(String[] args) {

        ConditionDemo conditionDemo = new ConditionDemo();

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(conditionDemo.new ThreadA());
        service.execute(conditionDemo.new ThreadB());
        service.execute(conditionDemo.new ThreadC());

        service.shutdown();

    }

    private class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                lock.lock();
                try {
                    while (currentThreadName != 'A'){
                        try {
                            conditionA.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    currentThreadName = 'B';
                    conditionB.signal();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    private class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                lock.lock();
                try {
                    while (currentThreadName != 'B'){
                        try {
                            conditionB.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    currentThreadName = 'C';
                    conditionC.signal();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    private class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                lock.lock();
                try {
                    while (currentThreadName != 'C'){
                        try {
                            conditionC.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    currentThreadName = 'A';
                    conditionA.signal();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

}
