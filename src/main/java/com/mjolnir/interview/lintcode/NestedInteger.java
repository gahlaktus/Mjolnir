package com.mjolnir.interview.lintcode;

import java.util.List;

/**
 * @author huangzhibo
 * @date 14/03/2018
 */
public interface NestedInteger {

    /**
     * @return true if this NestedInteger holds a single integer,
     * rather than a nested list.
     */
    boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();

}
