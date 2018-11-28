package com.mjolnir.spring.aop;

/**
 * @author huangzhibo
 * @date 22/03/2018
 */
public class Person implements Say{

    private String name;

    public Person(){
        super();
    }

    public Person(String name){
        this.name = name;
    }

    @Override
    public void sayHi() {
        System.out.println("My name is " + name + "!");
        throw new RuntimeException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
