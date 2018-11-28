package com.mjolnir.threads.synchronize;

/**
 * @author huangzhibo
 * @date 02/04/2018
 */
public class SynchronizedTest {

    public void m1(){

        System.out.println("m1 start");

        try {
            System.out.println("m1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m1 end");

    }

    public void m2(){

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
        final SynchronizedTest test = new SynchronizedTest();

        new Thread(() -> test.m1()).start();
        new Thread(() -> test.m2()).start();
    }

}
