package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 28/02/2018
 */
public class ReverseInteger {

    public int reverseInteger(int number) {
        int t1 = number % 10;
        int t2 = (number / 10) % 10;
        int t3 = number / 100;

        return t1 * 100 + t2 * 10 + t3;
    }

    public int reverseInteger1(int number) {
        int res = 0;
        while (number != 0){
            int k = number % 10;
            int temp = res;
            res = temp * 10 + k;
            number /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverseInteger1(123));
        System.out.println(reverseInteger.reverseInteger1(900));
    }

}
