package com;

import org.apache.commons.lang.StringUtils;

/**
 * @author huangzhibo
 * @date 30/06/2017
 */
public class Test {

    public void testIfStatement(String var1, String var2){
        if (null != var1){
            System.out.println("this is var1");
        }
        else if (null != var2){
            System.out.println("this is var2");
        }
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isNotEmpty(""));
    }
}
