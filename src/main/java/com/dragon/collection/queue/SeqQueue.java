package com.dragon.collection.queue;

import java.io.Serializable;

/**
 * @author huangzhibo
 * @date 2019/2/20
 */
public class SeqQueue<T> implements Queue<T>, Serializable {

    private static final long serialVersionUID = -1664818681270068094L;
    private static final int  DEFAULT_SIZE = 10;

    private T elementData[];

    private int front,rear;

    private int size;

    public SeqQueue(){
        elementData = (T[]) new Object[DEFAULT_SIZE];
        front = rear = 0;
    }

    public SeqQueue(int capacity){
        elementData = (T[]) new Object[capacity];
        front = rear = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean add(T data) {
        //扩容
        if (this.front == (this.rear + 1) % this.elementData.length){
            ensureCapacity(elementData.length * 2 + 1);
        }
        elementData[this.rear] = data;
        this.rear = (this.rear + 1) % elementData.length;
        size ++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        return false;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public void clearQueue() {

    }

    public void ensureCapacity(int capacity){

        if (capacity < size){
            return;
        }

        T[] old = elementData;
        elementData = (T[]) new Object[capacity];
        int j = 0;

        for (int i = this.front; i != this.rear ; i = (i + 1) % old.length) {
            elementData[j++] = old[i];
        }
        this.front = 0;
        this.rear = j;
    }

}
