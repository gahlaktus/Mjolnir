package com.stark.beautifulconcur;

/**
 * @author huangzhibo
 * @date 2019/6/18
 */
public class TestWaitFun {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread tA = new Thread(() -> {
            try {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("tA get resourceA lock");

                    // 获取resourceB共享资源的监视器锁
                    synchronized (resourceB) {
                        System.out.println("tA get resourceB lock");

                        // 线程A阻塞 ，并择放获取到的 resourceA的锁
                        System.out.println("tA release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tB = new Thread(() -> {
            try {
                Thread.sleep(1000);
                synchronized (resourceA) {
                    System.out.println("tB get resourceA lock");

                    System.out.println("tB try to get resourceB lock...");

                    // 获取resourceB共享资源的监视器锁
                    synchronized (resourceB) {
                        System.out.println("tB get resourceB lock");

                        // 线程A阻塞 ，并择放获取到的 resourceA的锁
                        System.out.println("tA release resourceA lock");
                        resourceA.wait();

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        tA.start();
        tB.start();

        tA.join();
        tB.join();

        System.out.println("main thread over");
    }
}
