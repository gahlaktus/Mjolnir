package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 27/02/2018
 */
public class APlusB {

    /**
     * 递归
     * @param a
     * @param b
     * @return
     */
    public int aplusb(int a, int b) {
        int res;
        int xor = a ^ b;
        int forward = (a & b) << 1;
        if (forward != 0) {
            res = aplusb(xor, forward);
        } else {
            res = xor;
        }
        return res;
    }

    public int aplusb1(int a, int b) {

        while (b != 0){
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            a = tempA;
            b = tempB;
        }
        return a;
    }

    public static void main(String[] args) {
        APlusB aPlusB = new APlusB();
        System.out.println(aPlusB.aplusb1(8, 2));
    }

}
