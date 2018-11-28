package com.dragon.refactor;

/**
 * @author huangzhibo
 * @date 31/07/2017
 */
public class Customer {

    private String name;

    public boolean isNull(){
        return false;
    }

    protected Customer(){}

    static Customer newNull(){
        return new NullCustomer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
