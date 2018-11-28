package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 02/03/2018
 */
public class HexConversion {

    public String hexConversion(int n, int k) {
        // write your code here
        char[] digitArr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        StringBuilder sb = new StringBuilder();
        if (n == 0){
            return "0";
        }
        while (n != 0){
            int temp = n % k;
            sb.append(digitArr[temp]);
            n /= k;
        }
        return sb.reverse().toString();
    }

}
