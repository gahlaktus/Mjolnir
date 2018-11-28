package com.dragon.concurrency;

/**
 * @author huangzhibo
 * @date 11/09/2017
 */
public class Test {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int RUNNING    = -1 << COUNT_BITS;     //左移运算

    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {
        System.out.println(COUNT_BITS);
        System.out.println(RUNNING);
        System.out.println(1 << COUNT_BITS);
        System.out.println(2 << 10);
        System.out.println(ctlOf(1,3));
        System.out.println(workerCountOf(1));
        System.out.println(runStateOf(12));
    }

    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }


}
