package com.dragon.java8;

/**
 * 函数式接口（Functional Interface）
 * 其实之前在讲Lambda表达式的时候提到过，
 * 所谓的函数式接口，当然首先是一个接口，然后就是在这个接口里面只能有一个抽象方法。
 * 这种类型的接口也称为SAM接口，即Single Abstract Method interfaces。
 * @author huangzhibo
 * @date 29/08/2017
 */
public interface FunctionInterface {

    void sayMessage(String msg);

    /*可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现*/
    default void doSomethingBefore(){
        System.out.println("before invoke sayMessage Method!");
    }

    default void doSomethingAfter(){
        System.out.println("after invoke sayMessage Method!");
    }

}
