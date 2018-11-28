package com.mjolnir.interview.lintcode.list;

import com.mjolnir.interview.lintcode.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 14/03/2018
 */
public class ListFlattern {

    public List<Integer> flatten(List<NestedInteger> nestedList) {

        List<Integer> res = new ArrayList<>();

        for (NestedInteger nestedInteger : nestedList) {

            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> t = nestedInteger.getList();
                List<Integer> cur = flatten(t);
                res.addAll(cur);
            }

        }
        return res;
    }

    public List<Integer> flatten1(List<NestedInteger> nestedList) {

        List<Integer> result = new ArrayList<>();
        for (NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                result.add(ele.getInteger());
            } else {
                result.addAll(flatten1(ele.getList()));
            }
        }
        return result;
    }

    /**
     * 非递归方法:空间，时间占用都比较大。
     * @param nestedList
     * @return
     */
    public List<Integer> flatten2(List<NestedInteger> nestedList) {

        boolean isFlat = true;

        List<NestedInteger> ls = nestedList;

        while (isFlat){
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<>();
            for (NestedInteger ni : ls){
                if (ni.isInteger()){
                    newLs.add(ni);
                }
                else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }

        List<Integer> r = new ArrayList<>();
        for (NestedInteger ni : ls){
            r.add(ni.getInteger());
        }
        return r;

    }
}
