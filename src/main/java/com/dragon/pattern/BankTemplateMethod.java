package com.dragon.pattern;

/**
 * Created by huangzhibo on 06/04/2017.
 */
public abstract class BankTemplateMethod {

    /**
     * Template Method Pattern
     */
    public void takeNumber(){
        System.out.println("取号排队");
    }

    public abstract void transact();    // hook

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){    // template method
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
