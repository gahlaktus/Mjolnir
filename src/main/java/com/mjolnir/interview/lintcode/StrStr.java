package com.mjolnir.interview.lintcode;

/**
 * 13. 字符串查找
 *
 * @author huangzhibo
 * @date 13/03/2018
 */
public class StrStr {

    public int strStr(String source, String target) {

        if (source == null || target == null || target.length() > source.length()) {
            return -1;
        }

        if (source.length() == 0 && target.length() == 0){
            return 0;
        }

        if (source.length() == 0){
            return -1;
        }
        if (target.length() == 0){
            return 0;
        }
        int len = target.length();

        for (int i = 0; i < source.length(); i++) {

            if (i+len > source.length()){
                return -1;
            }
            int k = 0;
            int j = i;
            while (j < source.length() && k < target.length()){

                if (source.charAt(j) != target.charAt(k)){
                    break;
                }
                k++;
                j++;
            }

            if (k  == len){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "lintcode";
        String target = "lintcode";

        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(source, target));
    }
}
