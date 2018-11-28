package com.dragon.codestyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzhibo
 * @date 07/09/2017
 */
public class TestAutoBoxNpe {

    public static void main(String[] args) {

        Map<String, Boolean> map = new HashMap<>();

        Boolean b = (map != null ? map.get("test") : false);

        System.out.println(b);

    }

}
