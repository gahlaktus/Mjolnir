package com.dragon.concurrency.thread.base;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 查看线程信息
 * @author huangzhibo
 * @date 18/09/2017
 */
public class MultiThread {

    public static void main(String[] args) {

        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        // 遍历线程信息，仅打印线程ID和线程名词信息
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"] " + threadInfo.getThreadName());
        }
    }

}
