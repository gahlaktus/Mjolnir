package com.mjolnir.design.adapter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huangzhibo
 * @date 06/01/2018
 */
public class MapAdapterDemo {

    public static void main(String[] args) {
        Integer[][] squares = {{2,4},{3,9},{4,16}};

        MapAdapter adapter = new MapAdapter(squares);
        System.out.println("adapter map contains: " + adapter);
    }

}

class MapAdapter extends AbstractMap {

    private Map map;

    public MapAdapter(Object[][] array){
        super();
        map = new HashMap();
        for (Object[] mapping : array){
            map.put(mapping[0], mapping[1]);
        }
    }

    @Override
    public Set<Entry> entrySet() {
        return map.entrySet();
    }
}
