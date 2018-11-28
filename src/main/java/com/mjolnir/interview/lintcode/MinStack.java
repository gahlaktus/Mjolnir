package com.mjolnir.interview.lintcode;

import java.util.Stack;

/**
 * @author huangzhibo
 * @date 27/02/2018
 */
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        dataStack.push(number);
        if (minStack.empty()){
            minStack.push(number);
            return;
        }
        int curMinVal = minStack.peek();
        if (curMinVal >= number){
            minStack.push(number);
        }
    }

    public int pop() {
        if (dataStack.isEmpty()){
            throw new RuntimeException("栈内无数据,非法操作！");
        }
        int value = dataStack.pop();
        if (min() == value){
            minStack.pop();
        }
        return value;
    }

    public int min() {
        return minStack.peek();
    }

}
