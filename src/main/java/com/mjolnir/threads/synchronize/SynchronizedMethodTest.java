package com.mjolnir.threads.synchronize;

/**
 * @author huangzhibo
 * @date 02/04/2018
 */
public class SynchronizedMethodTest {

    public synchronized void m1(){

        System.out.println("m1 start");

        try {
            System.out.println("m1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m1 end");

    }

    public synchronized void m2(){

        System.out.println("m2 start");

        try {
            System.out.println("m2 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m2 end");

    }

    public static void main(String[] args) {
        final SynchronizedMethodTest test = new SynchronizedMethodTest();

        new Thread(() -> test.m1()).start();
        new Thread(() -> test.m2()).start();
    }

}
