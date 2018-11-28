package com.mjolnir.interview.lintcode;

import java.util.Arrays;

/**
 * @author huangzhibo
 * @date 08/03/2018
 */
public class ArrayMaxDiff {

    public int maxDiff(int[][] arrs) {

        int[] firstArr = arrs[0];

        int max = 0;
        Arrays.sort(firstArr);

        int tempMaxItem = firstArr[firstArr.length-1];
        int tempMinItem = firstArr[0];

        for (int i = 1; i < arrs.length; i++) {

            int[] tempArr = arrs[i];
            Arrays.sort(tempArr);

            int t1 = tempArr[tempArr.length-1];
            int t2 = tempArr[0];
            if ( (t1- tempMinItem) > (tempMaxItem - t2)){
                max = t1-tempMinItem;
                tempMaxItem = t1;
            }
            else if ((t1- tempMinItem) == (tempMaxItem - t2) && tempMinItem < t2){
                max = t1-tempMinItem;
                tempMaxItem = t1;
            }
            else  {
                max = tempMaxItem - t2;
                tempMinItem = t2;
            }

        }

        return max;

    }

    public int maxDiff1(int[][] arrs){

        int num = arrs.length;
        /*
         * min[0]存放最小值，index存放数组的编号
         * */
        int[] min = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        int[] max = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        int[] indexMin = {-1,-1};
        int[] indexMax = {-1,-1};

        for(int i = 0; i < num; i++){
            int length = arrs[i].length;
            if(length == 0){
                continue;
            }
            if(arrs[i][0] < min[0]){
                min[1] = min[0];
                indexMin[1] = indexMin[0];
                min[0] = arrs[i][0];
                indexMin[0] = i;
            }
            else if(arrs[i][0] < min[1]){
                min[1] = arrs[i][0];
                indexMin[1] = i;
            }
            if(arrs[i][length-1] > max[0]){
                max[1] = max[0];
                indexMax[1] = indexMax[0];
                max[0] = arrs[i][length-1];
                indexMax[0] = i;
            }
            else if(arrs[i][length-1] > max[1]){
                max[1] = arrs[i][length-1];
                indexMax[1] = i;
            }

        }
        if(indexMin[0] != indexMax[0]){
            return Math.abs(max[0]- min[0]);
        }
        else{
            return Math.max(Math.abs(max[0] - min[1]), Math.abs(max[1] - min[0]));
        }

    }

    public static void main(String[] args) {
        int[][] test = {{2,3,4,5,6,7,8,9},{1,10},{-1,200}};
        ArrayMaxDiff arrayMaxDiff = new ArrayMaxDiff();
        System.out.println(arrayMaxDiff.maxDiff(test));
    }

}
