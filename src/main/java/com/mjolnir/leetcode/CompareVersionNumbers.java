package com.mjolnir.leetcode;

/**
 * @author huangzhibo
 * @date 08/01/2018
 */
public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLen = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLen; i++) {
            Integer num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int compareVal = num1.compareTo(num2);
            if (compareVal != 0){
                return compareVal;
            }
        }
        return 0;
    }

    public static int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLen = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLen; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 > num2){
                return 1;
            }
            else if (num1 < num2){
                return -1;
            }
        }
        return 0;
    }

    public static int compareVersion2(String version1, String version2) {
        int temp1 = 0,temp2 = 0;
        int len1 = version1.length(),len2 = version2.length();
        int i = 0,j = 0;
        while(i<len1 || j<len2) {
            temp1 = 0;
            temp2 = 0;
            while(i<len1 && version1.charAt(i) != '.') {
                temp1 = temp1*10 + version1.charAt(i++)-'0';

            }
            while(j<len2 && version2.charAt(j) != '.') {
                temp2 = temp2*10 + version2.charAt(j++)-'0';

            }
            if(temp1>temp2) return 1;
            else if(temp1<temp2) return -1;
            else {
                i++;
                j++;

            }

        }
        return 0;

    }

    public static int compareVersion3(String version1, String version2) {
        String ver1[] = version1.split("\\\\.");
        String ver2[] = version2.split("\\\\.");

        int len = ver1.length > ver2.length ? ver1.length : ver2.length;

        for (int i = 0; i < len; i++)
        {
            String v1 = i < ver1.length ? ver1[i] : "0";
            String v2 = i < ver2.length ? ver2[i] : "0";

            int compare = strCmp(v1, v2);
            if (compare != 0) return compare;
        }
        return 0;
    }

    public static int strCmp(String s1, String s2)
    {
        int len = s1.length() > s2.length() ? s1.length() : s2.length();
        for (int i = 0; i < len; i++)
        {
            char v1 = i + s1.length() < len ? '0' : s1.charAt(i - len + s1.length());
            char v2 = i + s2.length() < len ? '0' : s2.charAt(i - len + s2.length());
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion3("2.05", "2.1"));
    }

}
