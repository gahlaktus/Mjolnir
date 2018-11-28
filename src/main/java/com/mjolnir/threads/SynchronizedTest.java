package com.mjolnir.threads;

/**
 * @author huangzhibo
 * @date 2018/7/23
 */
public class SynchronizedTest {

    private static int cnt = 1;

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true){
                synchronized (this){
                    this.notify();
                    if (cnt <= 100){
                        String currentThreadName = Thread.currentThread().getName();
                        System.err.println(currentThreadName + ":" + cnt++);
                        try {
                            this.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

}
