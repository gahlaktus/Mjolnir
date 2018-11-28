package com.mjolnir.interview.lintcode.array;

/**
 * @author huangzhibo
 * @date 27/03/2018
 */
public class MaxSubArray {


    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int i = 1;
        int max = nums[0];
        int finalMax = max;
        while (i < nums.length){


            int temp = max + nums[i];
            if (max > temp && temp < 0) {
                max = 0;
            }
            else if (nums[i] > temp){
                max = nums[i];
            }
            else if (finalMax <= temp){
                max = temp;
                finalMax = max;
            }
            else {
                max = temp;
            }
            i++;

        }
        return finalMax;

    }

    public int maxSubArray1(int[] A){


        return -1;

    }

    public static void main(String[] args) {

        int[] t = {-2, 2, -3, 4, -1, 2, 1, -5, 3};

        int[] t1 = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};

        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(t1));
    }


}
