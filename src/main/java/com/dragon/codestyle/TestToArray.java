package com.dragon.codestyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 17/10/2017
 */
public class TestToArray {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");



        String[] array = new String[list.size()];

        array = list.toArray(array);

        for (String str : array){
            System.out.println(str);
        }
    }

}
