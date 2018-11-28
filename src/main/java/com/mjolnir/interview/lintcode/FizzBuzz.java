package com.mjolnir.interview.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 12/03/2018
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0){
                res.add("fizz buzz");
            }
            else if (i % 3 == 0){
                res.add("fizz");
            }
            else if (i % 5 == 0){
                res.add("buzz");
            }
            else {
                res.add(i+"");
            }

        }
        return res;

    }

    public List<String> fizzBuzz1(int n) {

        List<String> res = new ArrayList<>(n);

        int i = 1, p3 = 1, p5 = 1;

        while (i <= n){

            while (i < p3 * 3 && i < p5 * 5){
                res.add(i + "");
                i++;
            }

            if (i <= n && p3 * 3 == p5 * 5){
                res.add("fizz buzz");
                p3++;
                p5++;
                i++;
                continue;
            }

            while (i <= n && p3 * 3 <= i){
                res.add("fizz");
                p3++;
                i++;
            }

            while (i <= n && p5 * 5 <= i){
                res.add("buzz");
                p5++;
                i++;
            }
        }
        return res;
    }
}
