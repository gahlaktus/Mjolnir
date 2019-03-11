package com.dawanglu.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 2019/3/11
 */
public class GenericCase {

    private static void showKeyValue(Generic<Number> obj){
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    /**
     * 此处’？’是类型实参，而不是类型形参
     */
    private static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);

        showKeyValue(gNumber);
        // showKeyValue(gInteger);

        showKeyValue1(gNumber);
        showKeyValue1(gInteger);

        List<?>[] ls = new ArrayList<?>[10];

        // List<String>[] lsa1 = new List<String>[10]; // Not really allowed.
        List<String>[] lsa = new List[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        String s = lsa[1].get(0); // Run-time error: ClassCastException.


    }

}
