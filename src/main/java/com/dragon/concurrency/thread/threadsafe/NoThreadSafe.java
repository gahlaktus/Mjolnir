package com.dragon.concurrency.thread.threadsafe;

/**
 * @author huangzhibo
 * @date 31/08/2017
 */
public class NoThreadSafe {

    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }

}
