package com.dragon.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangzhibo
 * @date 16/06/2017
 */
public class OneUtils {

    public static void main(String[] args) {

       String[] arr1 = {"粤AR557Q",
                "豫A8PL81",
                "豫AR70U7",
                "闽C155AP",
                "鲁M0586H",
                "粤B2MT58",
                "豫A529FK",
                "云A5QF73",
                "陕AA5S96",
                "云FUU606",
                "鄂AC2M02",
                "川A86AV7",
                "豫AQ178T",
                "鲁M00305",
                "闽CH320M",
                "皖CS2811",
                "川FP0658",
                "川A0U73W",
                "渝CCK033",
                "鄂AZ95M2",
                "辽AF61U0",
                "贵ATL998",
                "晋A39M79",
                "鲁CUW663",
                "鲁M7521X",
                "皖H58550",
                "宁A863M1",
                "鄂AQ2T16",
                "粤L5M495",
                "粤LRG888",
                "黑AQC460",
                "湘A4EQ86",
                "粤A3ML10",
                "渝CAA850",
                "苏NQM287",
                "蒙GBM508",
                "渝AWL846",
                "粤BT688Q",
                "云A2KT73",
                "苏E732ZP"};

       List<String> list1 = Arrays.asList(arr1);

       String[] arr2 = {
               "云A2KT73",
               "云FUU606",
               "川A0U73W",
               "川A86AV7",
               "川FP0658",
               "晋A39M79",
               "渝AWL846",
               "渝CAA850",
               "渝CCK033",
               "湘A4EQ86",
               "皖CS2811",
               "皖H58550",
               "粤A3ML10",
               "粤AR557Q",
               "粤B2MT58",
               "粤L5M495",
               "粤LRG888",
               "苏E732ZP",
               "苏NQM287",
               "蒙GBM508",
               "豫A529FK",
               "豫A8PL81",
               "豫AQ178T",
               "贵ATL998",
               "辽AF61U0",
               "鄂AQ2T16",
               "鄂AZ95M2",
               "闽C155AP",
               "闽CH320M",
               "鲁CUW663",
               "鲁M00305",
               "鲁M0586H",
               "鲁M7521X",
               "黑AQC460"
       };
        List<String> list2 = Arrays.asList(arr2);

        for (String item : list1){
            if (list2.contains(item)){}
            else {
                System.out.println(item);
            }
        }

    }
}
