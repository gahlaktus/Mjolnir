package main.java.com.thread.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author huangzhibo
 * @date 29/08/2017
 */
public class ExecutorTest1 {

    static final ExecutorService executor = CustomizedThreadpool.newFixedThreadPool(10);

    public static void main(String args[]) {


        fun(executor, 100);

        try {
            executor.shutdown();
            executor.awaitTermination(20000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
        }
    }

    public static void fun(final ExecutorService executor, final int taskNum){
        Random random = new Random();
        int waitTime = 500;
        for (int i = 0; i < taskNum; i++) {
            String name = "线程 " + i;
            int time = random.nextInt(10000);
            waitTime += time;
            Runnable runner = new ExecutorThread(name, time);
            System.out.println("增加: " + name + " / " + time);
            executor.execute(runner);
        }

    }

}
