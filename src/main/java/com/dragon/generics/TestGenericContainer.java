package com.dragon.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 09/10/2017
 */
public class TestGenericContainer {

    @Test
    public void testGenericContainer(){

        GenericContainer<Integer> myInt = new GenericContainer<>();

        myInt.setObj(3);
        //myInt.setObj("Test");
        System.out.println("Value of container: "+myInt.getObj());

        System.out.println("********************************");

        List myObjectList = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            ObjectContainer myObj = new ObjectContainer();
            myObj.setObj("Test: "+i);
            myObjectList.add(myObj);
        }

        for (int i = 0; i <= myObjectList.size() - 1; i++) {
            ObjectContainer obj = (ObjectContainer) myObjectList.get(i);
            System.out.println("Object Value: "+obj.getObj());
        }

        List<GenericContainer> genericContainers = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            GenericContainer<String> myGeneric = new GenericContainer<>();
            myGeneric.setObj("generic Test: "+i);
            genericContainers.add(myGeneric);
        }

        for (GenericContainer<String> obj : genericContainers){
            String objStr = obj.getObj();
            System.out.println(objStr);
        }

    }

}
