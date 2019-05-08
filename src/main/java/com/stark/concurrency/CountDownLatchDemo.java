package com.stark.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangzhibo
 * @date 2019/5/7
 */
public class CountDownLatchDemo {

    /**
     * 主线程开启N个子线程并阻塞；子线程等待主线程通知开启工作，主线程阻塞，等待所有子线程执行完毕后继续后续工作。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        int N = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        // do something
        System.out.println("worker开始工作的前置步骤！");
        startSignal.countDown();
        // do something
        System.out.println("what happen here....");
        doneSignal.await();
        System.out.println("All worker had been done!");
    }

}

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal){
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println("do something before this worker works." + Thread.currentThread().getName());
            startSignal.await();
            doWork();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }

    private void doWork(){
        System.out.println("This Worker start to work now" + Thread.currentThread().getName());
    }
}