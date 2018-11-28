package com.dragon.codestyle;

/**
 * @author huangzhibo
 * @date 07/09/2017
 */
public class StringSplitTest {

    public static void main(String[] args) {

        String strTest = "1,2,3";

        String[] arr = strTest.split(",", -1);
        System.out.println(arr.length);


    }

}
