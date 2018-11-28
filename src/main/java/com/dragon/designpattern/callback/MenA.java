package com.dragon.designpattern.callback;

/**
 * @author huangzhibo
 * @date 25/08/2017
 */
public class MenA implements CallBack{


    private MenB menB;

    public MenA(MenB menB){
        this.menB = menB;
    }

    public void askQuestion(final String question){

        new Thread(() -> menB.executeMessage(MenA.this, question)).start();

        play();
    }

    private void play() {
        System.out.println("I do my own things !");
    }

    @Override
    public void solve(String result) {
        System.out.println("the solved result is : " + result);
    }
}
