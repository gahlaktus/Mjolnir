package main.java.com.thread.threadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    public static void main(String args[]) {

        for (int i = 0; i < 50; i++) {
            fun();
        }

    }

    public static void fun(){
        Random random = new Random();
        //产生一个 ExecutorService 对象，这个对象带有一个大小为 poolSize 的线程池，若任务数量大于 poolSize ，任务会被放在一个 queue 里顺序执行。
        ExecutorService executor = CustomizedThreadpool.newFixedThreadPool(10);
        // 判断可是线程池可以结束
        int waitTime = 500;
        for (int i = 0; i < 10; i++) {
            String name = "线程 " + i;
            int time = random.nextInt(10000);
            waitTime += time;
            Runnable runner = new ExecutorThread(name, time);
            System.out.println("增加: " + name + " / " + time);
            executor.execute(runner);
        }
        try {
            Thread.sleep(waitTime);
            executor.shutdown();
            executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
        }
    }
}  
  