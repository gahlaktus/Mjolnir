package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 28/02/2018
 */
public class DigitCounts {

    public int digitCounts(int k, int n) {

        if (n < k) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < n + 1; i++) {
            if (i == k) {
                sum += 1;
            } else {
                int j = i;
                while (j != 0) {
                    int temp = j % 10;
                    j /= 10;
                    if (temp == k) {
                        sum += 1;
                    }
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        DigitCounts digitCounts = new DigitCounts();
        System.out.println(digitCounts.digitCounts(1, 12));
    }

}
