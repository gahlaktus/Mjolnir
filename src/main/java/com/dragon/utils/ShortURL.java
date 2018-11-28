package com.dragon.utils;

import java.util.ArrayList;

/**
 * @author huangzhibo
 * @date 23/10/2017
 */
public class ShortURL {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    //public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
    public static final int BASE = ALPHABET.length();

    public static String encode(int num) {

        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt(num % BASE));
            num = num / BASE;
        }
        return str.toString();
    }

    public static int decode(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return num;
    }

    private ShortURL(){}

    public static ArrayList<Integer> base62(int id) {
        ArrayList<Integer> value = new ArrayList<>();
        while (id > 0) {
            int remainder = id % 62;
            value.add(remainder);
            id = id / 62;
        }
        return value;
    }

    public static int base10(ArrayList<Integer> base62) {

        for (int i = 1; i <= 6 - base62.size(); i++) {
            base62.add(0,0);
        }

        int id = 0;
        int size = base62.size();
        for (int i = 0; i < size; i++) {
            int value = base62.get(i);
            id += (int)(value * Math.pow(62, size - i - 1));
        }
        return id;
    }

    /*
     *  用数据库来保存长地址和短地址的映射，那么，在表 LongtoShortURL 中，我们会有三列：
     1. ID，int,  自动增长；
     2. LURL，varchar,  // 长URL；
     3. SURL, varchar,  // 短URL。
     */
}
