package com.dragon.collection;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author huangzhibo
 * @date 12/06/2017
 */
public class Test {

    public static void main(String[] args) {

        Collection collection = Arrays.asList(1, 2, -1, 33, 7);

        System.out.println(CollectionUtils.getNewLinkedHashSet(collection));

    }
}
