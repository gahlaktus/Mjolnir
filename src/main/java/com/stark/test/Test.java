package com.stark.test;

import java.math.BigDecimal;

/**
 * @author huangzhibo
 * @date 2019/5/15
 */
public class Test {

    public static void main(String[] args) {

        String s = "9.86";

        Float f = Float.valueOf(s);

        f = f * 100;
        Long result = f.longValue();

        System.out.println(result);


        BigDecimal d1 = new BigDecimal(0.6);
        BigDecimal d2 = new BigDecimal(0.4);
        BigDecimal d3 = d1.divide(d2, 1, BigDecimal.ROUND_HALF_UP);
        System.out.println(d3);

//
//        BigDecimal d1 = new BigDecimal("0.6");
//        BigDecimal d2 = new BigDecimal("0.4");
//        BigDecimal d3 = d1.divide(d2);
//        System.out.println(d3);

    }

}
