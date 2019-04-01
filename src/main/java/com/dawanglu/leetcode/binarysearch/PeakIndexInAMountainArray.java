package com.dawanglu.leetcode.binarysearch;

/**
 * @author huangzhibo
 * @date 2019/3/28
 */
public class PeakIndexInAMountainArray {

    /*
     * 分析：
     * 这个峰值存在的特性，左边为递增，右边为递减。
     * 二分查找，该值左右均小于它。
     */

    /**
     * 非递归实现
     */
    public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length < 3){
            return -1;
        }
        int end = A.length - 1;
        int start = 0;
        int cur = (start + end) / 2;
        int targetIndex = -1;
        while (cur > 0 && cur < end){
            if (A[cur -1] < A[cur] && A[cur + 1] < A[cur]){
                targetIndex = cur;
                break;
            }
            if (A[cur -1] < A[cur] && A[cur + 1] > A[cur]){
                start = cur;
                cur = (start + end) / 2;
                continue;
            }
            if (A[cur -1] > A[cur] && A[cur + 1] < A[cur]){
                end = cur;
                cur = (start + end) / 2;
            }
        }
        return targetIndex;
    }

    private static int findPeakIndex(int[] arr, int start, int end){

        int cur = (start + end) / 2;
        if (cur < 1 || cur > arr.length-2){
            return -1;
        }
        if (arr[cur - 1] < arr[cur] && arr[cur + 1] < arr[cur]){
            return cur;
        }
        if (arr[cur-1] < arr[cur] && arr[cur + 1] > arr[cur]){
            return findPeakIndex(arr, cur, end);
        }
        if (arr[cur - 1] > arr[cur] && arr[cur] > arr[cur + 1]){
            return findPeakIndex(arr, start, cur);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        System.out.println(findPeakIndex(arr, 0, arr.length));
    }

}
