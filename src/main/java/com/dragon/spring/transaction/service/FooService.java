package com.spring.transaction.service;

import com.spring.transaction.Foo;

/**
 * @author huangzhibo
 * @date 31/07/2017
 */
public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
