package com.dragon.collection.queue;

/**
 * @author huangzhibo
 * @date 2019/2/20
 */
public interface Queue<T> {

    int size();

    boolean isEmpty();

    boolean add(T data);

    boolean offer(T data);

    T peek();

    T element();

    T poll();

    T remove();

    void clearQueue();

}
