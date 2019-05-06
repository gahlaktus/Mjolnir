package com.stark.concurrency;

/**
 * @author huangzhibo
 * @date 2019/5/5
 */
public class Waiter implements Runnable{

    private final Message msg;

    public Waiter(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        synchronized(msg){

            try {
                System.out.println(threadName+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(threadName+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(threadName+" processed: "+msg.getMsg());
        }

    }
}
