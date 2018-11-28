package com.mjolnir.design.adapter;

/**
 * @author huangzhibo
 * @date 06/01/2018
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
