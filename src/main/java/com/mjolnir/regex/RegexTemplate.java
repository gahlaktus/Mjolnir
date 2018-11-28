package com.mjolnir.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangzhibo
 * @date 14/12/2017
 */
public class RegexTemplate {

    private static final Pattern REGEX_PATTERN = Pattern.compile("(.*)-(\\d+\\.\\d+).*");

    /**
     * 6-20位，全是数字、或者字母、或者数字与字母组合的
     */
    private static final Pattern ALPHABET_OR_NUMBER_PATTERN = Pattern.compile("^\\d{6,20}$|^[A-Za-z]{6,20}$|^[0-9A-Za-z]{6,20}$");


    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d{6,20}$");

    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[A-Za-z]{6,20}$");


    private static final Pattern ALPHABET_AND_NUMBER_PATTERN = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{8,16}$");

    public static void main(String[] args) {

//        String testStr = "aaaaaaaaaa";
//
//        Matcher matcher = ALPHABET_OR_NUMBER_PATTERN.matcher(testStr);
//
//        if (matcher.matches()){
//            System.out.println("yes");
//        }
//        else {
//            System.out.println("no");
//        }

        String t = "建设银行";
        replaceChinese(t);

    }
    private static final String CHINESE_REGEX = "[^\\u4E00-\\u9FA5]";

    private static void replaceChinese(String str) {
        Matcher matcher = Pattern.compile(CHINESE_REGEX).matcher(str);
        String tt = matcher.replaceAll("");
        System.out.println(tt);

        if (Pattern.compile(CHINESE_REGEX).matcher(str).matches()){
            System.out.println(str.replace(CHINESE_REGEX, ""));
        }
    }

}
