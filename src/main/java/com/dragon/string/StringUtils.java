package com.dragon.string;

/**
 * @author huangzhibo
 * @date 20/07/2017
 */
public class StringUtils {

    public static boolean isNotEmpty(String str){
        return !StringUtils.isEmpty(str);
    }

    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    private static final String GPS_IO_FLAG = "GPSIOFLAG";
    public static void main(String[] args) {
        System.out.println(GPS_IO_FLAG.charAt(0));
        String sourceId = "123456GPSIOFLAG";

        if (sourceId.contains(GPS_IO_FLAG)){
            sourceId = sourceId.substring(0, sourceId.indexOf(GPS_IO_FLAG.charAt(0)));
        }
        Long sourceIdL = Long.parseLong(sourceId);
        System.out.println(sourceIdL);
    }
}
