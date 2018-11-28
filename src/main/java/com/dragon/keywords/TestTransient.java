package com.dragon.keywords;

import java.io.*;

/**
 * @author huangzhibo
 * @date 03/08/2017
 */
public class TestTransient implements Serializable {

    public static void main(String[] args) throws Exception{
        NameStore nameStore = new NameStore("Steve",
                "Middle","Jobs");

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("nameStore"));

        o.writeObject(nameStore);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("nameStore"));
        NameStore nameStore1 = (NameStore) in.readObject();
        System.out.println(nameStore1);

    }
}
