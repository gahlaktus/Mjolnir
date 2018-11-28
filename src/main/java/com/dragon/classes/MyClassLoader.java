package com.dragon.classes;

/**
 * @author huangzhibo
 * @date 02/08/2017
 */
public class MyClassLoader extends ClassLoader{

    public Class<?> defineMyClass(byte[] b, int off, int len){
        return super.defineClass(b, off, len);
    }

}
