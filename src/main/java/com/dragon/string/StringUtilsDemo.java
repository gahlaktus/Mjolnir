package com.dragon.string;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public class StringUtilsDemo {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("ww");
        strList.add("dd");
        strList.add("ff");
        strList.add("bb");
        strList.add("nn");
        String res0 = StringUtils.join(strList, ",");
        System.out.println(res0);

        List<Integer> integerList = new ArrayList<Integer>();
//        integerList.add(90);
//        integerList.add(777);
//        integerList.add(22);
//        integerList.add(33);
        for (int i = 0; i < 300; i++){
            integerList.add(i);
        }
        String res1 = StringUtils.join(integerList, "+");
        System.out.println(res1);
    }
}
