package com.mjolnir.interview.lintcode;

/**
 * 因数分解质因数， 结果中每个0（10） 都可以分解成2 * 5；
 * 因此有多少对（2， 5）就有多少个0；因为2的个数是多余5的，因此计算5的个数即可！
 * @author huangzhibo
 * @date 28/02/2018
 */
public class TrailingZeros {

    /**
     * 错误
     * @param n
     * @return
     */
    public long trailingZeros(long n){
        long sum = 1;
        for (long i = 1; i < n+1; i++) {
            sum = sum * i;
        }
        int num = 0;
        while ((sum % 10) == 0){
            num ++;
            sum = sum / 10;

        }
        return num;
    }

    /**
     * 错误
     * @param n
     * @return
     */
    public long trailingZeros1(long n){
        int pivot = 5;
        int sum = 0;
        while (n / pivot > 0){
            sum += n / pivot;
            pivot = pivot * 5;
        }
        return sum;
    }

    /**
     * 正确
     * @param n
     * @return
     */
    public long trailingZeros2(long n){
        long sum = 0;
        while (n != 0){
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        TrailingZeros trailingZeros = new TrailingZeros();
        //System.out.println(trailingZeros.trailingZeros(105));
        System.out.println(trailingZeros.trailingZeros2(5555550000000L));

    }

}
