package com.dragon.classes;

/**
 * 成员变量初始化是在父类构造函数调用完后，在此之前，成员变量的值均是默认值
 * @author huangzhibo
 * @date 20/06/2017
 */
public class A extends B{

    public int a = 100;

    public A(){
        super();
        System.out.println(a);
        a=200;
    }

    public static void main(String[] args) {
        System.out.println(new A().a);
    }
}

class B {

    public B(){
        System.out.println(((A)this).a);
    }
}