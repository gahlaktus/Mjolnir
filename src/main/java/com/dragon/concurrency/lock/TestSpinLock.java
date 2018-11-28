package com.dragon.concurrency.lock;

/**
 * 自旋锁
 * @author huangzhibo
 * @date 12/09/2017
 */
public class TestSpinLock {

    public static void main(String[] args) {
        int i = 0;
        for (;;){
            System.out.println(i++);
            if (i == 1000)
                break;
        }
    }

}
