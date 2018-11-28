package com.mjolnir.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzhibo
 * @date 2018/9/10
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // cached solution
        int[] solution = new int[2];

        int[] tempArr = new int[10];
        for(int i = 0; i < nums.length; i++){
            int k = nums[i];
            if (k <= 9){
                if (tempArr[k] == 0){
                    tempArr[k] = i+1;
                    if (tempArr[9-k] != 0){
                       solution[0] = tempArr[9-k] -1;
                       solution[1] = i;
                       break;
                    }
                } else {
                    if (9 - k == k){
                        solution[0] = tempArr[9-k] -1;
                        solution[1] = i;
                        break;
                    }
                }
            }
        }

        return solution;
    }

    public int[] twoSum1(int[] nums, int target) {

        int[] solution = new int[2];

        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (tempMap.get(k) == null){
                if (tempMap.get(target-k) != null){
                    solution[0] = tempMap.get(target-k);
                    solution[1] = i;
                    break;
                } else {
                    tempMap.put(k, i);
                }
            } else {
                if (target-k == k){
                    solution[0] = tempMap.get(target-k);
                    solution[1] = i;
                    break;
                }
            }
        }

        return solution;
    }

    public int[] twoSum2(int[] nums, int target){

        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(nums[i])){
                return new int[]{tempMap.get(nums[i]), i};
            }
            tempMap.put(target-nums[i], i);
        }

        throw new IllegalArgumentException("答案不存在！");
    }


    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        int[] testArr = {2, 7, 11, 15};

        int[] testArr1 = {3, 2, 4};

        int[] solution = twoSum.twoSum2(testArr1, 6);

        for (int v : solution) {
            System.out.println(v);
        }
    }

}
