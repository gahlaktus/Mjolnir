package com.dawanglu.generic;

/**
 * @author huangzhibo
 * @date 2019/3/11
 */
public class Generic<T> {

    private T key;

    public Generic(T key){
        this.key = key;
    }

    public T getKey(){
        return key;
    }

}
