package com.mjolnir.string;

import java.time.ZoneId;

/**
 * @author huangzhibo
 * @date 18/12/2017
 */
public class StringOperations {

    public static void main(String[] args) {

        String bankStr = "123";
        int len = bankStr.length();

        String last4BankCardNo = len > 3 ? bankStr.substring(len-4) : bankStr;

        System.out.println(last4BankCardNo);

        String joined = String.join("/", "user", "local", "bin");
        System.out.println(joined);

        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);

    }

}
