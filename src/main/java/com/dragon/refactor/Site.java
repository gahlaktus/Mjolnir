package com.dragon.refactor;

/**
 * @author huangzhibo
 * @date 31/07/2017
 */
public class Site {

    Customer _customer;

    Customer getCustomer(){
        return (_customer == null) ? Customer.newNull() : _customer;
    }
}
