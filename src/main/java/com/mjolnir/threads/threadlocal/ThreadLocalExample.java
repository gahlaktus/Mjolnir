package com.mjolnir.threads.threadlocal;

/**
 * @author huangzhibo
 * @date 21/12/2017
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int)(Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){

            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread t1 = new Thread(sharedRunnableInstance);
        Thread t2 = new Thread(sharedRunnableInstance);
        t1.start();
        t2.start();
    }

}
