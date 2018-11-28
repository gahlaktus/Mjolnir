package com.mjolnir.interview.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author huangzhibo
 * @date 29/03/2018
 */
public class LinkedStack<T> implements Stack<T>, Serializable {

    private static final long serialVersionUID = 1911829302658328353L;

    private Node<T> top;

    private int size;

    public LinkedStack(){
        this.top = new Node<>();
    }
    public int size(){
        return size;
    }


    class Node<T> {

        private T data;

        Node next;

        Node(){
            super();
        }

        Node(T data){
            this.data = data;
        }
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

    }

    @Override
    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    @Override
    public void push(T data){
        if (data == null){
            throw new RuntimeException("data cant\'t be null");
        }

        if (this.top == null){
            this.top = new Node<>(data);
        }
        else if (this.top.data == null){
            this.top.data = data;
        }
        else {
            top = new Node<>(data, this.top);
        }
        size ++;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public static void main(String[] args){
        LinkedStack<String> sl=new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        sl.push("C");
        int length=sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->"+sl.pop());
        }
    }
}
