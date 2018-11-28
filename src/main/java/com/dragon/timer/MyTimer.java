package com.dragon.timer;

import java.util.Timer;

/**
 * Created by huangzhibo on 06/06/2017.
 */
public class MyTimer {

    public static void main(String[] args) {

        Timer timer = new Timer();

        MyTimerTask myTimerTask = new MyTimerTask("测试");

        timer.schedule(myTimerTask, 2000L, 1000L);


    }
}
