package com.dawanglu.datastructure;

/**
 * @author huangzhibo
 * @date 2019/4/28
 */
public class SinglyLinkedList<T> {

    private Node<T> head, tail;

    protected transient int modCount = 0;

    transient int size = 0;

    public SinglyLinkedList(){
        head = null;
        tail = null;
    }

    public void add(T t){

        final Node<T> l = tail;
        final Node<T> newNode = new Node<>(t);
        tail = newNode;

        if (l == null){
            head = newNode;
        } else {
            l.next = newNode;
        }

        size++;
        modCount++;

    }

    public T peek(){
        final Node<T> f = head;
        return (f == null) ? null : f.value;
    }

    public T poll(){
        final Node<T> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    private T unlinkFirst(Node<T> f){

        assert f == head && f != null;

        final T element = f.value;
        final Node<T> next = f.next;

        // help GC
        f.value = null;
        f.next = null;

        head = next;

        if (next == null){
            tail = null;
        }

        size--;
        modCount++;
        return element;

    }

}

class Node<T> {

    T value;

    Node<T> next;

    Node(){
    }

    Node(T t){
        value = t;
        next = null;
    }

    Node(T t, Node next){
        value = t;
        next = next;
    }

}