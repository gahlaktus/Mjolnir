package com.dragon.java8;

/**
 * @author huangzhibo
 * @date 29/08/2017
 */
public class Test {

    public static void main(String[] args) {
        String msg = "hhh";
        FunctionInterface functionInterface = msg1 -> System.out.println("Hello " + msg);
        functionInterface.doSomethingBefore();
        functionInterface.sayMessage(msg);
        functionInterface.doSomethingAfter();
    }

}
