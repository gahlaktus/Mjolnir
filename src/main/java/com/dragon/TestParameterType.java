package com;

/**
 * @author huangzhibo
 * @date 29/08/2017
 */
public class TestParameterType {

    public static void main(String[] args) {
        int x = 1;
        int y = x;
        System.out.println("x = "+x+", y = "+y);
        x = 2;
        System.out.println("x = "+x+", y = "+y);

    }

}
