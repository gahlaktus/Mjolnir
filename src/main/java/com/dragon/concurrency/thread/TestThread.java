package com.dragon.concurrency.thread;

import com.dragon.concurrency.thread.MyThread;

/**
 * Created by huangzhibo on 30/03/2017.
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //匿名类
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName());
            }
        };
        thread.start();
    }
}
