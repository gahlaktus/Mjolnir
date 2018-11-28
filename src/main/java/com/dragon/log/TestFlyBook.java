package com.dragon.log;

/**
 * Created by huangzhibo on 24/04/2017.
 */
public class TestFlyBook {

    public static void main(String[] args) {

        LogProxy logProxy = new LogProxy();

        FlyBookInterface flyBookInterface = (FlyBookInterface) logProxy.bind(new FlyBook());

        flyBookInterface.doBook("美联航");
    }
}
