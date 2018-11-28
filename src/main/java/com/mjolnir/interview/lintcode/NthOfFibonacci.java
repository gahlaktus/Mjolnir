package com.mjolnir.interview.lintcode;

/**
 * 考虑空间、以及递归会不会超时（即递归深度、重复递归）
 * @author huangzhibo
 * @date 26/02/2018
 */
public class NthOfFibonacci {

    static int fibonacci(int i){
        if (i <= 0){
            return -1;
        }
        if (i  == 1){
            return 0;
        }
        if (i == 2){
            return 1;
        }
        return fibonacci(i-1)+fibonacci(i-2);
    }

    static int fibonacci1(int n){
        if (n <= 0){
            return -1;
        }
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int[] tempArr = new int[n];
        tempArr[0] = 0;
        tempArr[1] = 1;
        for (int i = 2; i < n; i++) {
            tempArr[i] = tempArr[i-1]+tempArr[i-2];
        }
        return tempArr[n-1];
    }

    static int fibonacci2(int n){
        if(n < 1) {
            return 0;
        }

        int[] fib = {0, 1, 1};

        for (int i = 3; i < n; ++i) {
            fib[i % 3] = fib[(i - 1) % 3] + fib[(i - 2) % 3];
        }

        return fib[(n - 1) % 3];
    }

    static int fibonacci3(int n){
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci3(47));
    }

}
