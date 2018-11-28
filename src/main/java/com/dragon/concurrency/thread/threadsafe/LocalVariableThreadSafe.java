package com.dragon.concurrency.thread.threadsafe;

/**
 * 局部变量线程安全
 * @author huangzhibo
 * @date 07/09/2017
 */
public class LocalVariableThreadSafe implements Runnable{

    @Override
    public void run() {
        int local_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取local_i 的值:" + local_i);
        local_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取local_i*2的值:" + local_i * 2);
    }

    public static void main(String[] args) {

        LocalVariableThreadSafe localVariableThreadSafe = new LocalVariableThreadSafe();

        for (int i = 0; i < 3000; i++) {
            new Thread(localVariableThreadSafe, "线程"+i).start();
        }
    }
}
