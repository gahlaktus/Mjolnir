package com.test.java.junit;

import com.dragon.junit.SortMethod;
import org.junit.Test;

import java.util.Random;

/**
 * @author huangzhibo
 * @date 19/05/2017
 */
public class SortMethodTest {

    @Test(timeout = 2000)
    public void qSort() throws Exception {
        int[] arr = new int[50000];
        int arrLength = arr.length;

        Random r = new Random();
        for (int i = 0; i < arrLength; i++){
            arr[i] = r.nextInt(arrLength);
        }
        new SortMethod().qSort(arr);
    }

    @Test(timeout = 2000)
    public void sort() throws Exception {
        int[] arr = new int[50000];
        int arrLength = arr.length;

        Random r = new Random();
        for (int i = 0; i < arrLength; i++){
            arr[i] = r.nextInt(arrLength);
        }
        new SortMethod().sort(arr);
    }

}