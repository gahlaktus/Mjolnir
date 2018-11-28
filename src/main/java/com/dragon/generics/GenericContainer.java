package com.dragon.generics;

/**
 * @author huangzhibo
 * @date 09/10/2017
 */
public class GenericContainer<T> {

    private T obj;

    public GenericContainer(){
    }

    // pass type in as parameter to constructor
    public GenericContainer(T t){
        obj = t;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
