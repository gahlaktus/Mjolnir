package LeetCode;

import java.util.Arrays;

/**
 * Problem:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * @author huang
 * 
 * 实际上，这是一个排序问题。
 *
 */
public class FindMedianSortedArrays {
	public static double findMedianSortedArrays(int[] A, int[] B){
		//方法1，合并数组。 其时间复杂度为 O（m+n）， 空间复杂图为O（m+n)
		/*int[] numsA = new int[nums1.length+nums2.length];
		int n1a = 0, n2a = 0, na = 0;
		while(n1a < nums1.length && n2a < nums2.length){
			numsA[na++] = (nums1[n1a] < nums2[n2a])?nums1[n1a++]:nums2[n2a++];
		}
		while(n1a < nums1.length){
			numsA[na++] = nums1[n1a++];
		}
		while(n2a < nums2.length){
			numsA[na++] = nums2[n2a++];
		}
		System.out.println(Arrays.toString(numsA));
		return (numsA.length - 1)/2;*/
		
		// Binary Search
		int n = A.length, m = B.length;
		if( n > m){
			return findMedianSortedArrays(B, A);	//make sure len(A) <= len(B)
		}
		
		int k = (n + m - 1) / 2;
		int l = 0, r = Math.min(k, n);
		while( l < r){
			int midA = (l + r) / 2;
			int midB = k - midA;
			if(A[midA] < B[midB]){
				l = midA + 1;
			}
			else{
				r = midA;
			}
		}
			int a = Math.max(l > 0? A[l - 1]: Integer.MIN_VALUE, k - l >= 0? B[k-l]:Integer.MIN_VALUE);
			if(((n + m) & 1) == 1)	// check if (n+m) is odd
				return (double) a;
			
			int b = Math.min(l < n?A[l] : Integer.MAX_VALUE, k-l+1 < m?B[k-l+1]:Integer.MAX_VALUE);
			return (a + b) / 2.0;
	}
	
	public static void main(String[] args) {
		int[] a = {};
		int[] b = {2};
		System.out.println((6+7)/2);
		System.out.println(findMedianSortedArrays(a, b));
	}
}
