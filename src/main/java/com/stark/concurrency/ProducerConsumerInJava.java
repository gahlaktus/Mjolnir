package com.stark.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author huangzhibo
 * @date 2019/5/5
 */
public class ProducerConsumerInJava {

    public static void main(String[] args) throws Exception {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumper Problem");

        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Producer(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
        producer.start();
        consumer.start();
    }

}

/**
 * wait函数规范代码模板
 * // The standard idiom for calling the wait method in Java
 * synchronized(sharedObject) {
 * while(condition) {
 * sharedObject.wait();
 * // (Releases lock, and reacquires on wakeup)
 * }
 * // do action based upon condition e.g. take or put into queue
 * }
 */

class Producer extends Thread {

    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();
            }

        }
    }
}

class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}