package com.mjolnir.interview.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author huangzhibo
 * @date 29/03/2018
 */
public class SeqStack<T> implements Stack<T>, Serializable {

    private static final long serialVersionUID = -5413303117698554397L;

    private int top = -1;

    private int capacity = 10;

    private T[] array;

    private int size;


    public int size(){
        return size;
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    public SeqStack(int capacity){
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {

        if(array.length == size){
            ensureCapacity(size*2+1);
        }

        array[++top] = data;
        size++;

    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public T pop() {

        if (isEmpty()){
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    public void ensureCapacity(int capacity){
        if (capacity < size){
            return;
        }
        T[] old = array;
        array = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            array[i] = old[i];
        }
    }


    public static void main(String[] args) {

        SeqStack<String> seqStack = new SeqStack<>();
        seqStack.push("A");
        seqStack.push("B");
        seqStack.push("C");
        System.out.println("size -> " + seqStack.size());

        int len = seqStack.size();
        for (int i = 0; i < len; i++){
            System.out.println("seqStack.pop -> " + seqStack.pop());
        }
        System.out.println("seqStack.peek -> " + seqStack.peek());

    }
}
