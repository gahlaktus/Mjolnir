package com.dragon.designpattern.callback;

/**
 * @author huangzhibo
 * @date 25/08/2017
 */
public class MenB {


    public void executeMessage(CallBack callBack, String question) {

        System.out.println("the question is :" + question);

        for (int i = 0; i < 10000; i++) {

        }

        String result = "结果";

        callBack.solve(result);
    }

}
