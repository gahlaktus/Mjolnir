package main.java.com.collection.list;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 26/06/2017
 */
public class TestSomeUtils {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(stringList)){
            System.out.println("not empty!!!");
        }
        else if (CollectionUtils.isEmpty(stringList)){
            System.out.println("empty!!!!");
        }
    }
}
