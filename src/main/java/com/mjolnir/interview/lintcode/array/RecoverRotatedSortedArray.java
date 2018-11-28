package com.mjolnir.interview.lintcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 23/03/2018
 */
public class RecoverRotatedSortedArray {

    public void recoverRotatedSortedArray(List<Integer> nums) {

        if (nums == null || nums.size() == 0){
            return;
        }

        int pivot = 0;

        for (int i = 1; i < nums.size(); i++) {

            if (nums.get(i-1) > nums.get(i)){
                pivot = i;
                break;
            }

        }

        int k = nums.size() - pivot;

        int j = nums.size();

        int m = 0;
        int a = m;
        int temp = 0;
        while (m < pivot){


            if (m < pivot){

                if (temp != 0){
                    int t1 = nums.get(m+k);
                    nums.set(m+k, temp);
                    temp = t1;
                    m = m+k;
                    j--;
                }
                else {
                    temp = nums.get(m + k);
                    nums.set(m+k, nums.get(m));
                    m = m+k;
                    j--;
                }

            }

            if (m >= pivot){

                if (temp != 0){
                    int t1 = nums.get(m-pivot);
                    nums.set(m-pivot, temp);
                    temp = t1;
                    m = m-pivot;
                    j--;
                }
                else {
                    temp = nums.get(m-pivot);
                    nums.set(m-pivot, nums.get(m));
                    m = m-pivot;
                    j--;
                }

            }
            if (m == a){
                nums.set(a, temp);
                m = a+1;
                temp = 0;
            }
            else if (m >= pivot && j == 1){

                nums.set(a, temp);

            }


        }

    }


    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public void recoverRotatedSortedArray1(List<Integer> nums) {
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                reverse(nums, 0, index);
                reverse(nums, index + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> t = new ArrayList<>();
        t.add(5);
        t.add(6);
        t.add(7);
        t.add(8);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);

        RecoverRotatedSortedArray recoverRotatedSortedArray = new RecoverRotatedSortedArray();
        recoverRotatedSortedArray.recoverRotatedSortedArray1(t);

    }

}
