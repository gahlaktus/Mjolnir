package com.dragon.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 09/10/2017
 */
public class TestObjectContainer {

    @Test
    public void testObjectContainer(){
        ObjectContainer container = new ObjectContainer();

        // store a string
        container.setObj("Test");
        System.out.println("Value of container: "+container.getObj());

        // store an int(which is autoboxed to an Integer object)
        container.setObj(3);
        System.out.println("Value of container: "+container.getObj());

        List objectList = new ArrayList();
        objectList.add(container);

        // 需要进行繁琐的类型转换
        int num = (int) ((ObjectContainer)objectList.get(0)).getObj();
        System.out.println("num: "+num);
    }

}
