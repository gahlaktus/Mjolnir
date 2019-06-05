package com.stark.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangzhibo
 * @date 2019/5/29
 */
public class SubList {

    public static <T> void pagination(List<T> list, int pageSize){

        int totalCount = list.size();

        int pageCount;

        int m = totalCount % pageSize;

        if (m > 0){
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        for (int i = 1; i <= pageCount; i++){
            if (m == 0){
                List<T> subList = list.subList((i-1)*pageSize, pageSize*i);
                System.out.println(subList);
            } else {
                if (i==pageCount){
                    List<T> subList= list.subList((i-1)*pageSize,totalCount);
                    System.out.println(subList);
                }else{
                    List<T> subList= list.subList((i-1)*pageSize,pageSize*(i));
                    System.out.println(subList);
                }
            }
        }
    }

    public static <T> List<T> pagination(List<T> list, int pageSize, int pageNumber){

        int totalCount = list.size();
        int pageCount;

        int m = totalCount % pageSize;

        if (m > 0){
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        List<T> subList = Collections.emptyList();
        if (pageNumber <= pageCount){
            if (m == 0){
                subList = list.subList((pageNumber-1)*pageSize, pageSize*pageNumber);
            } else {
                if (pageNumber==pageCount){
                    subList= list.subList((pageNumber-1)*pageSize,totalCount);
                }else{
                    subList= list.subList((pageNumber-1)*pageSize,pageSize*(pageNumber));
                }
            }
        }
        return subList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            list.add(i);
        }
        pagination(list, 10);

        System.out.println(pagination(list, 10, 7));
    }

}
