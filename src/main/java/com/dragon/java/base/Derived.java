package com.dragon.java.base;

/**
 * Created by huangzhibo on 05/04/2017.
 */
public class Derived extends Base{
    public String whenAnISet = "set when declared";
    @Override
    void preProcess(){
        whenAnISet = "set in preProcess()";
    }
}
