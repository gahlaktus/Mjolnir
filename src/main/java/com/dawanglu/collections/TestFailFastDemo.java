package com.dawanglu.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 2019/4/15
 */
public class TestFailFastDemo {

    public static void main(String[] args) {

        List<String> userNames = new ArrayList<String>(){{
            add("Jimmy");
            add("jimmy");
            add("JimmyHuang");
            add("J");
        }};

        for (String userName : userNames) {
            if (userName.equals("Jimmy")){
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);

    }

}
