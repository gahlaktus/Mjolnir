package main.java.com.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author huangzhibo
 * @date 29/08/2017
 */
public class CustomizedThreadpool extends ThreadPoolExecutor {

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new CustomizedThreadpool(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("beforeExecute-线程池需要执行的任务数量: "+getTaskCount());
        System.out.println("beforeExecute-线程池在运行过程中已完成的任务数量: "+getCompletedTaskCount());
        System.out.println("beforeExecute-线程池曾经创建过的最大线程数量: "+getLargestPoolSize());
        System.out.println("beforeExecute-线程池的线程数量: "+getPoolSize());
        System.out.println("beforeExecute-活动的线程数: "+getActiveCount());

    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("afterExecute-线程池需要执行的任务数量: "+getTaskCount());
        System.out.println("afterExecute-线程池在运行过程中已完成的任务数量: "+getCompletedTaskCount());
        System.out.println("afterExecute-线程池曾经创建过的最大线程数量: "+getLargestPoolSize());
        System.out.println("afterExecute-线程池的线程数量: "+getPoolSize());
        System.out.println("afterExecute-活动的线程数: "+getActiveCount());
    }

    @Override
    protected void terminated() {
        System.out.println("terminated-线程池需要执行的任务数量: "+getTaskCount());
        System.out.println("terminated-线程池在运行过程中已完成的任务数量: "+getCompletedTaskCount());
        System.out.println("terminated-线程池曾经创建过的最大线程数量: "+getLargestPoolSize());
        System.out.println("terminated-线程池的线程数量: "+getPoolSize());
        System.out.println("terminated-活动的线程数: "+getActiveCount());
    }

    public CustomizedThreadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public CustomizedThreadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public CustomizedThreadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public CustomizedThreadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }
}
