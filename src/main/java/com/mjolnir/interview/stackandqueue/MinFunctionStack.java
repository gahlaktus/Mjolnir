package com.mjolnir.interview.stackandqueue;

import java.util.Stack;

/**
 * 在jdk中，栈有两种实现方式：
 * 其一：继承数组链表实现的Vector的Stack类；
 * 其二：继承Queue接口的Deque接口；
 * @author huangzhibo
 * @date 20/11/2017
 */
public class MinFunctionStack{

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinFunctionStack(){
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(Integer data){
        if (minStack.isEmpty() || data < minStack.peek()){
            minStack.push(data);
        }
        dataStack.push(data);
    }

    public Integer pop(){
        if (dataStack.isEmpty()){
            throw new RuntimeException("Your dataStack is empty.");
        }
        Integer value = dataStack.pop();
        if (value.equals(getMin())){
            minStack.pop();
        }
        return value;
    }

    public Integer getMin(){
        if (minStack.isEmpty()){
            throw new RuntimeException("Your minStack is empty.");
        }
        return minStack.peek();
    }

}
