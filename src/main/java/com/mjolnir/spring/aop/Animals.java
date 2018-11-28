package com.mjolnir.spring.aop;

/**
 * @author huangzhibo
 * @date 22/03/2018
 */
public class Animals implements Say{

    @Override
    public void sayHi() {
        System.out.println("I am a animal");
    }
}
