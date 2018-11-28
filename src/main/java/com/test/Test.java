package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangzhibo
 * @date 2018/9/18
 */
public class Test {

    private static final Pattern REGEX_PATTERN = Pattern.compile("(.*)-(\\d+(\\.\\d+)*).*");


    public static void main(String[] args) {
        String accept = "application/vnd.easefin.app-3.3";
        Matcher matcher = REGEX_PATTERN.matcher(accept);
        if (matcher.matches()) {
            String actualMediaType = matcher.group(1);
            String version = matcher.group(2);
            System.out.println(actualMediaType);
            System.out.println(version);
            //LogUtils.debug(Log.CTRL_DIGEST_LOGGER, "Version={}", version);
        }
    }

}
