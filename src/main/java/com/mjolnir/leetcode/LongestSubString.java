package com.mjolnir.leetcode;

/**
 * @author huangzhibo
 * @date 20/12/2017
 */
public class LongestSubString {

    public static int lengthOfLongestSubString(char[] sequence){

        int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int len = 0, i =-1, tmp;

        for (int j = 0; j < sequence.length; j++) {
            tmp = arr[sequence[j]];
            i = Math.max(tmp, i);
            arr[sequence[j]] = j;
            len = Math.max(len, j-i);
        }

        return len;
    }

    public static String longestSubString(char[] sequence){

        int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int len = 0, i =-1, tmp;
        int l = 0, r = 0;
        for (int j = 0; j < sequence.length; j++) {
            tmp = arr[sequence[j]];
            i = Math.max(tmp, i);
            arr[sequence[j]] = j;
            len = Math.max(len, j-i);
            if (j-i > len){
                l = i;
                r = j;
                len = j-i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = l; k < r+1; k++){
            sb.append(sequence[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "123cnagsacnddeioc333";
        System.out.println(lengthOfLongestSubString(str.toCharArray()));
        System.out.println(longestSubString(str.toCharArray()));
    }

}
