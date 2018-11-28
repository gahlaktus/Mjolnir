package com.mjolnir.interview.lintcode.sort;

/**
 * 冒泡排序
 * 选择排序
 * 插入排序
 * <p>
 * <p>
 * 内排序
 *
 * @author huangzhibo
 * @date 26/02/2018
 */
public class SortIntegers {

    /**
     * 冒泡排序, O(n^2)
     *
     * @param integerArr
     */
    private static void bubbleSort(int[] integerArr) {

        int len = integerArr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (integerArr[j] > integerArr[j + 1]) {
                    int tempVal = integerArr[j];
                    integerArr[j] = integerArr[j + 1];
                    integerArr[j + 1] = tempVal;
                }
            }
        }

    }

    /**
     * 选择排序, O(n^2)
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        int minIndex;

        for (int i = 0; i < arr.length - 1; i++) {

            minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }

        }

    }

    /**
     * 插入排序, O(n^2)
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {


        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            int j = i;
            int target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;

        }

    }

    public static int partition(int[] arr, int left, int right) {

        int pivotKey = arr[left];
        int pivotPointer = left;

        while (left < right) {
            while (left < right && arr[right] >= pivotKey) {
                right--;
            }
            while (left < right && arr[left] <= pivotKey) {
                left++;
            }
            swap(arr, left, right);
        }

        swap(arr, pivotPointer, left);
        return left;
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(arr, left, right);
        sort(arr, left, pivotPos - 1);
        sort(arr, pivotPos + 1, right);
    }

    public static void quickSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);

    }

    public static void quick_sort(int[] arr, int l, int r) {

        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[j] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quick_sort(arr, l, i - 1);
            quick_sort(arr, i + 1, r);
        }

    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 4, 5};
        //bubbleSort(test);
        //quickSort(test);
        quick_sort(test, 0, test.length-1);
        for (int val : test) {
            System.out.println(val);
        }
    }

}
