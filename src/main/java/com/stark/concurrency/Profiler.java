package com.stark.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author huangzhibo
 * @date 2019/5/6
 */
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static final void begin(){
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " millis");
    }
}
