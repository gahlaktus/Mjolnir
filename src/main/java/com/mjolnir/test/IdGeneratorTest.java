package com.mjolnir.test;

import com.solarterms.kokuu.commons.id.util.IdGeneratorUtils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangzhibo
 * @date 2018/9/10
 */
public class IdGeneratorTest {

    public static void main(String[] args) {
        int count = 1000;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++)
            executorService.execute(new IdGeneratorTest().new Task(cyclicBarrier));

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                // 等待所有任务准备就绪
                cyclicBarrier.await();
                // 测试内容
                IdGeneratorUtils.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
