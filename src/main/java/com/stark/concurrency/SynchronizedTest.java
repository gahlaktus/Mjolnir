package com.stark.concurrency;

/**
 * @author huangzhibo
 * @date 2019/5/21
 */
public class SynchronizedTest {


    public void method1(){
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Method 1 finished");
    }

    public void method2(){
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Method 2 finished");
    }

    public static void main(String[] args) {
        final SynchronizedTest syncTest = new SynchronizedTest();

        new Thread(() -> syncTest.method1()).start();

        new Thread(() -> syncTest.method2()).start();
    }

}
