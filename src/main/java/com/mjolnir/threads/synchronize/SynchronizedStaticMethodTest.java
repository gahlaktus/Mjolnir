package com.mjolnir.threads.synchronize;

/**
 * @author huangzhibo
 * @date 02/04/2018
 */
public class SynchronizedStaticMethodTest {

    public static synchronized void m1(){

        System.out.println("m1 start");

        try {
            System.out.println("m1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m1 end");

    }

    public static synchronized void m2(){

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
        final SynchronizedStaticMethodTest test1 = new SynchronizedStaticMethodTest();

        final SynchronizedStaticMethodTest test2 = new SynchronizedStaticMethodTest();


        new Thread(() -> test1.m1()).start();
        new Thread(() -> test2.m2()).start();
    }

}
