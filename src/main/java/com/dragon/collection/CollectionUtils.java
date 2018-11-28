package com.dragon.collection;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.*;

/**
 * 一些方法工具
 * @author huangzhibo
 * @date 12/06/2017
 */
public class CollectionUtils {

    public static <E> Set<E> getNewLinkedHashSet(Collection<E> elements){
        return asUnmodifiableOrderedSet(elements);
    }

    private static <E> Set<E> asUnmodifiableOrderedSet(Collection<E> elements){
        List<E> list = new ArrayList<>();
        list.addAll(elements);
        Collections.sort(list, AnnotationAwareOrderComparator.INSTANCE);
        return new LinkedHashSet<>(list);
    }
}
