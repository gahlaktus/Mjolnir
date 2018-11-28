package com.mjolnir.concurrency;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;

/**
 * @author huangzhibo
 * @date 2018/7/16
 */
public class TestCompletedFuture {

    @Test
    static void completedFutureExample(){
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals( "message", (cf.getNow(null)));
    }

    @Test
    static void runAsyncExample(){
        CompletableFuture cf = CompletableFuture.runAsync(() ->{
            assertTrue(Thread.currentThread().isDaemon());
            //Thread.sleep();
        });
    }

    public static void main(String[] args) {
        TestCompletedFuture.completedFutureExample();
    }
}
