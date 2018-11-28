package com.dragon.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huangzhibo
 * @date 20/07/2017
 */
public class StringUtilsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isNotEmpty() throws Exception {
        System.out.println(StringUtils.isNotEmpty(null));
        System.out.println(StringUtils.isNotEmpty("     "));
        System.out.println(StringUtils.isNotEmpty(""));
    }

    @Test
    public void isEmpty() throws Exception {
    }

}