package com.dragon.concurrency.practise;

/**
 * @author huangzhibo
 * @date 2018/11/28
 */
public class SyncObj {

    private char letter = 'A';

    public void nextLetter() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'A';
                break;
            default:
                break;
        }
    }

    public char getLetter() {
        return letter;
    }
}
