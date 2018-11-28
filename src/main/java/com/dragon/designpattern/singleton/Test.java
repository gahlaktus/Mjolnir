package com.dragon.designpattern.singleton;

import org.junit.Assert;

/**
 * @author huangzhibo
 * @date 20/06/2017
 */
public class Test {

    @org.junit.Test
    public void checkIODHTaskManager(){
        IODHTaskManager i1, i2;
        i1 = IODHTaskManager.getInstance();
        i2 = IODHTaskManager.getInstance();
        Assert.assertEquals(i1, i2);
    }
}
