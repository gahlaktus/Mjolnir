package com.mjolnir.leetcode2;

/**
 * @author huangzhibo
 * @date 2018/9/10
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       int m = nums1.length;

       int n = nums2.length;

       if (m > n) {
           int[] temp = nums1;
           nums1 = nums2;
           nums2 = temp;

           int tmp = m;
           m = n;
           n = tmp;
       }

       int halfLen = (m + n + 1) / 2;
       int iMin = 0, iMax = m;
       while (iMin <= iMax){
           int i = (iMin + iMax) / 2;
           int j = halfLen - i;
           if (i < iMax && nums2[j-1] > nums1[i]){
               iMin = i + 1;
           }
           else if (i > iMin && nums1[i-1] > nums2[j]){
               iMax = i -1;
           }
           else {
               int maxLeft;
               if (i == 0) {
                   maxLeft = nums2[j-1];
               }
               else if (j == 0){
                   maxLeft = nums1[i-1];
               }
               else {
                   maxLeft = Math.max(nums1[i-1], nums2[j-1]);
               }
               if ((m + 2) % 2 == 1){
                   return maxLeft;
               }

               int minRight;
               if (i == m){
                   minRight = nums2[j];
               }
               else if (j == n){
                   minRight = nums1[i];
               }
               else {
                   minRight = Math.min(nums1[i], nums2[j]);
               }

               return (maxLeft + minRight) / 2.0;
           }
       }

       return 0;

    }

}
