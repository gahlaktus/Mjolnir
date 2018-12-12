package com.dragon.java.generic;

import lombok.Getter;

/**
 * @author huangzhibo
 * @date 2018/12/6
 */
@Getter
public class TwoTuple<A, B> {

    private final A first;

    private final B second;

    public TwoTuple(A a, B b){
        first = a;
        second = b;
    }

}
