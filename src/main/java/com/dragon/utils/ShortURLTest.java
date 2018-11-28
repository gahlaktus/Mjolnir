package com.dragon.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huangzhibo
 * @date 23/10/2017
 */
public class ShortURLTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        System.out.println(ShortURL.encode(1));
    }

    @Test
    public void decode() throws Exception {
    }

    @Test
    public void base62() throws Exception {
        System.out.println(ShortURL.base62(1));
    }

    @Test
    public void base10() throws Exception {
    }

}