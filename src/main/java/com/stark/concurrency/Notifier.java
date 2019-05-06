package com.stark.concurrency;

/**
 * @author huangzhibo
 * @date 2019/5/5
 */
public class Notifier implements Runnable {

    private final Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(threadName + " Notifier work done");
//                msg.notify();

                // notify 只会唤醒等待线程中一个线程，其它没有被唤醒的线程将一直等待下去，notifyAll唤醒所有等待的线程，只有一个等待的线程获取cpu马上执行，其它的线程依次执行。
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
