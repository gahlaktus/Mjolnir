package com.dragon;

/**
 * Created by huangzhibo on 05/04/2017.
 */

class Base {
    Base(){
        preProcess();
    }
    void preProcess(){}
}
public class Derived extends Base{
    public String whenAnISet = "set when declared";
    @Override
    void preProcess(){
        whenAnISet = "set in preProcess()";
    }
}
