package com.dragon.collection.list;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huangzhibo on 05/04/2017.
 */
public class InitList {

    public static void main(String[] args) {
        ArrayList<Integer> list0 = new ArrayList<Integer>();

        list0.add(1);
        list0.add(2);
        list0.add(3);


        ArrayList<Integer> list1 = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> list2 = Arrays.asList(1,2,3);

        // guava
        List<Integer> list3 = ImmutableList.of(1,2,3);

        ArrayList<Integer> list4 = createArrayList(1,2,3);
    }

    // 工厂方法
    public static <T> ArrayList<T> createArrayList(T ... elements) {
        ArrayList<T> list = new ArrayList<T>();
        for (T elem : elements){
            list.add(elem);
        }
        return list;
    }
}
