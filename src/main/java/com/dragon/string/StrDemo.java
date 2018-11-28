package com.dragon.string;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by huangzhibo on 02/05/2017.
 */
public class StrDemo {
    public static void main(String[] args) {
        String str = "GPS";
        String string = "移交类";

        String testStr0 = "*移交类(3.5%)";
        int testRes = testStr0.indexOf(string);
        System.out.println(testRes);

        String uuid = RandomStringUtils.randomAlphanumeric(8);
        System.out.println(uuid);
    }
}
