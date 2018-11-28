package com.dragon.timer;

import java.util.TimerTask;

/**
 * Created by huangzhibo on 05/06/2017.
 */
public class MyTimerTask extends TimerTask{
    private String name;

    public MyTimerTask(String inputName){
        name = inputName;
    }


    @Override
    public void run() {
        System.out.println("my new timer task!!!" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
