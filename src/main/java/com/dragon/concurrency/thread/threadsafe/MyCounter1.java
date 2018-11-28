package com.dragon.concurrency.thread.threadsafe;

/**
 * Created by huangzhibo on 19/05/2017.
 */
public class MyCounter1 {

    private static int counter = 0;

    public static synchronized int getCount(){
        return counter++;
    }

    /**
     * when synchronized is added to a static method, the Class object is the object which is locked.
     * if the method is not static, then adding synchronized keyword will synchronized the instance of the class,
     * not the Class object.
     */
}
