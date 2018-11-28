package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 13/03/2018
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return -1;
        }

        int k = nums.length / 2;
        int max_index = nums.length-1;
        int pre_index = 0;
        while (k < nums.length && k > -1){
            if (pre_index == k){
                break;
            }
            if (nums[k] > target){
                max_index = k;
                pre_index = k;
                k = k / 2;
            }
            else if (nums[k] < target){
                pre_index = k;
                k = (max_index + k) / 2;
            }
            else {
                while (true){
                    int cur = k;
                    k--;
                    if ( k < 0 || nums[k] != target){
                        return cur;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {4,5,9,9,12,13,14,15,15,18};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(test, 10));
    }

}
