package com.dragon.string;

import com.google.common.base.Splitter;


/**
 * @author huangzhibo
 * @date 25/09/2017
 */
public class GuavaStringUtils {

    public static void main(String[] args) {
         for (String str : Splitter.on(',').trimResults().omitEmptyStrings().split(" foo")){
             System.out.println(str);
         }
    }

}
