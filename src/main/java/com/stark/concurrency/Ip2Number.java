package com.stark.concurrency;

import com.stark.datastructure.tree.TreeNode;

/**
 * @author huangzhibo
 * @date 2019/6/18
 */
public class Ip2Number {

    private static Long ipToLong(String ip) {
        Long ips = 0L;
        String[] numbers = ip.split("\\.");
        for (String number : numbers) {
            ips = ips << 8 | Integer.parseInt(number);
        }
        return ips;
    }

    public static void main(String[] args) {

        String i1 = "192.68.0.1";
        String i2 = "192.189.2.1";
        String i3 = "10.189.2.1";
        String i4 = "10.10.2.1";

        System.out.println(ipToLong(i1));
        System.out.println(ipToLong(i2));
        System.out.println(ipToLong(i3));
        System.out.println(ipToLong(i4));
    }

}
