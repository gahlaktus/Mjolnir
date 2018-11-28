package com.mjolnir.interview.lintcode;

import java.util.Arrays;

/**
 * 6. 合并排序数组 II
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * @author huangzhibo
 * @date 05/03/2018
 */
public class MergeSortedArray {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {

        int lenA = A.length;
        int lenB = B.length;

        int[] newArr = new int[lenA+lenB];
        int i = 0, j = 0, k=0;
        while (i <= lenA && j <= lenB){
            if (i <= lenA-1 && j <= lenB-1 && A[i] <= B[j]){
                newArr[k++] = A[i++];
            }
            else if (j <= lenB-1){
                newArr[k++] = B[j++];
            }
            else if (i <= lenA-1){
                newArr[k++] = A[i++];
            }
            else {
                break;
            }
        }
        return newArr;
    }

    public int[] mergeSortedArray1(int[] A, int[] B) {


        int[] newArr = new int[A.length+B.length];

        int i=0, j=0, k=0;

        while (i != A.length && j != B.length){
            if (A[i] > B[j]){
                newArr[k] = B[j++];
            }
            else {
                newArr[k] = A[i++];
            }
            k++;
        }

        if (i != A.length){
            while (i != A.length){
                newArr[k++] = A[i++];
            }
        }
        else {
            while (j != B.length){
                newArr[k++] = B[j++];
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 5};
        int[] t2 = {2, 3};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        Arrays.stream(mergeSortedArray.mergeSortedArray1(t1, t2)).forEach(System.out::println);
    }

}
