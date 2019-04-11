package com.dawanglu.jvmdemo;

/**
 * @author huangzhibo
 * @date 2019/4/1
 */
public class NotInitialization {

    public static void main(String[] args) {
        //System.out.println(SubClass.value);

        System.out.println("-------------------");

        // 通过数组定义来引用类，不会触发此类的初始化！
        SuperClass[] sca = new SuperClass[10];


        // 常量传播优化，此常量的值"hello world"存储到了NotInitialization类的常量池中。
        System.out.println(ConstClass.HELLOWORLD);
    }

}
