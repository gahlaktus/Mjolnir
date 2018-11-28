package com.mjolnir.interview.array;

/**
 * @author huangzhibo
 * @date 09/04/2018
 */
public class FindRepeatNum {

    public int findRepeatNum(int[] arr){

        if (arr == null || arr.length == 0){
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] != i){

                if (arr[arr[i]] == arr[i]){
                    return arr[i];
                }

                int temp = arr[arr[i]];

                arr[arr[i]] = arr[i];
                arr[i] = temp;

            }

        }
        return arr.length;

    }

    public boolean findRepeatNumber(int[] arr){

        if (arr == null || arr.length == 0){
            return false;
        }

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] != i){

                if (arr[arr[i]] == arr[i]){
                    return true;
                }

                int temp = arr[arr[i]];

                arr[arr[i]] = arr[i];
                arr[i] = temp;

            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5};
        FindRepeatNum findRepeatNum = new FindRepeatNum();
        System.out.println(findRepeatNum.findRepeatNum(arr));
    }

}
