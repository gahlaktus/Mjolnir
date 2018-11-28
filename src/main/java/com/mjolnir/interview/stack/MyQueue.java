package com.mjolnir.interview.stack;

import java.util.EmptyStackException;
import java.util.Stack;
/**
 * @author huangzhibo
 * @date 30/03/2018
 */
public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        // do intialization if necessary

    }

    public void push(int element) {
        s1.push(element);
    }

    public int pop() {
        if (!s2.isEmpty()){
            return s2.pop();
        }
        else if (!s1.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        throw new EmptyStackException();
    }

    public int top() {
        if (!s2.isEmpty()){
            return s2.peek();
        }
        else if (!s1.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
        throw new EmptyStackException();
    }


}
