package com.dragon.integer;

/**
 * @author huangzhibo
 * @date 01/08/2017
 */
public class IntegerUtils {

    public static void main(String[] args) {
        Integer integer = 2;
        System.out.println(customizedEquals(integer, null));
    }

    public static boolean customizedEquals(Integer int1, Integer int2){
        return int1 != null && int2 != null && int1.intValue() == int2.intValue();
    }
}
