package com.mjolnir.jvm;

/**
 * @author huangzhibo
 * @date 19/03/2018
 */
public class NotInitialization1 {

    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }

}
