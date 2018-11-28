package com.dragon.designpattern.callback;

/**
 * @author huangzhibo
 * @date 25/08/2017
 */
public class Test {
    public static void main(String[] args) {

        MenB menB = new MenB();

        MenA menA = new MenA(menB);

        menA.askQuestion("你好");
    }

}
