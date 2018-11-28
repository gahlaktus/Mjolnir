package com.mjolnir.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author huangzhibo
 * @date 17/01/2018
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        return sets.size();
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curNum = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curNum){
                curNum = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        int[] newNums = new int[j];
        for (int i = 0; i < j; i++) {
            newNums[i] = nums[i];
        }
        nums = newNums;
        return j;
    }

    public static int removeDuplicates3(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int curNum = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curNum){
                curNum = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    public static int removeDuplicates4(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }


    public static int removeDuplicatesN(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        nums = Arrays.stream(nums).distinct().toArray();
        return nums.length;

    }

    public static void main(String[] args) {

    }
}
