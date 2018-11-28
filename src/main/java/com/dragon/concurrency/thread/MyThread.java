package com.dragon.concurrency.thread;

/**
 * Created by huangzhibo on 30/03/2017.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName());
    }
}
