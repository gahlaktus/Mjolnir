package com.stark.concurrency;

/**
 * @author huangzhibo
 * @date 2019/5/6
 */
public class VolatileExample {

    int a = 0;

    volatile boolean flag = false;

    public void writer(){
        // 1
        a = 1;
        // 2
        flag = true;
    }

    public void reader(){
        // 3
        if (flag){
            // 4
            int i = a;
        }
    }

}
