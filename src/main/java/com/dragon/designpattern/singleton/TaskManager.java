package com.dragon.designpattern.singleton;

/**
 * 简单的单例
 * @author huangzhibo
 * @date 20/06/2017
 */
public class TaskManager {

    private static TaskManager tm = null;
    private TaskManager(){}

    public void displayProccess(){}
    public void displayService(){}

    public TaskManager getInstance(){
        if (null == tm){
            tm = new TaskManager();
        }
        return tm;
    }
}
