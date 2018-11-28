package com.mjolnir.interview.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 28/02/2018
 */
public class KthPrimes {

    private static boolean divisible(int n, List<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return true;
            }
        }
        return false;
    }

    public int kthPrime(int n) {
        // write your code here

        if (n == 1) {
            return 2;
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int k = 2;
        int pivot = 2;
        int val = pivot;
        while (k <= n) {
           if (!divisible(pivot, primes)){
               primes.add(pivot);
               val = pivot;
           }
           k++;
           pivot++;
        }
        return val;
    }

    public int kthPrime1(int n) {
        // write your code here

        if (n == 2) {
            return 1;
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int k = 2;
        int pivot = 2;
        while (true) {
            if (!divisible(pivot, primes)){
                primes.add(pivot);
                if (pivot == n){
                    return k;
                }
                k++;
            }
            pivot++;
        }
    }


    public static void main(String[] args) {
        KthPrimes kthPrimes = new KthPrimes();
        System.out.println(kthPrimes.kthPrime1(11));
    }

}
