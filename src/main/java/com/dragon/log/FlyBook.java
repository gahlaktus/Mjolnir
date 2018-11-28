package com.dragon.log;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public class FlyBook implements FlyBookInterface{

    @Override
    public void doBook(String name) {
        System.out.println("Hello" + name);
    }
}
