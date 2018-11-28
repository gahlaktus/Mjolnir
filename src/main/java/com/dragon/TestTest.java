package com;

import org.junit.*;

/**
 * @author huangzhibo
 * @date 24/07/2017
 */
public class TestTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testIfStatement() throws Exception {

        Test test = new Test();
        test.testIfStatement("var1", "var2");
    }

}