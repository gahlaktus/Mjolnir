package com.mjolnir.practise;

/**
 * @author huangzhibo
 * @date 2018/9/18
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        if (m > n) {

            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempLen = m;
            m = n;
            n = tempLen;

        }

        int iMin = 0, iMax = m;
        int halfLen = (m + n + 1) / 2;

        while (iMin <= iMax) {

            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }

        }

        return 0.0;

    }


    public double findMedianSortedArrays1(int[] A, int[] B) {

        if ((A.length + B.length) % 2 == 1) {
            return helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2 + 1);
        } else {
            return (helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2) + helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2 + 1)) / 2.0;
        }

    }

    private int helper(int[] A, int[] B, int i, int i2, int j, int j2, int k) {
        int m = i2 - i + 1;
        int n = j2 - j + 1;
        if (m > n) {
            return helper(B, A, j, j2, i, i2, k);
        }
        if (m == 0) {
            return B[j + k - 1];
        }
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }
        int posA = Math.min(k / 2, m);
        int posB = k - posA;
        if (A[i + posA - 1] == B[j + posB - 1]) {
            return A[i + posA - 1];
        } else if (A[i + posA - 1] < B[j + posB - 1]) {
            return helper(A, B, i + posA, i2, j, j + posB - 1, k - posA);
        } else {
            return helper(A, B, i, i + posA - 1, j + posB, j2, k - posB);
        }
    }


    /**
     * 二分查找
      */
    public double findMedianSortedArrays2(int[] A, int[] B) {


        int m = A.length, n = B.length;

        if (n < m) {
            int[] temp = A;
            A = B;
            B = temp;

            int tempLen = m;
            m = n;
            n = tempLen;
        }

        int halfLen = (m + n + 1) / 2;

        int iMin = 0, iMax = m;

        while (iMax > iMin){

            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i > iMin && A[i-1] > B[j]){
                iMax = i-1;
            }
            else if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1;
            }
            else {

                int maxLeft;
                if (i == 0){
                    maxLeft = B[j-1];
                } else if (j == 0){
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                if ((m + n) % 2 == 1){
                    return maxLeft;
                }

                int minRight;
                if (i == m){
                    minRight = B[j];
                }else if (j == n){
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }

                return (maxLeft + minRight) / 2.0;

            }

        }

        return 0;

    }
}
