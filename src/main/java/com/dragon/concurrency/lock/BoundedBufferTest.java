package com.dragon.concurrency.lock;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangzhibo
 * @date 20/09/2017
 */
public class BoundedBufferTest {

    private static final Logger logger = LoggerFactory.getLogger(BoundedBufferTest.class);

    private static BoundedBuffer buffer = null;

    @Before
    public void init(){
        if (buffer == null){
            synchronized (BoundedBufferTest.class){
                if (buffer == null){
                    buffer = new BoundedBuffer();
                }
            }
        }
    }

    @Test
    public void put() throws Exception {

        logger.info("[有界缓存]-大小: {}",buffer.items.length);

        buffer.put(111);



    }

    @Test
    public void take() throws Exception {
        buffer.put(111);

        logger.info("[有界缓存]-取缓存值: {}",buffer.take());


    }

}