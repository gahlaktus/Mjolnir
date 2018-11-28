package com.dragon.designpattern.singleton;

import java.util.Arrays;

/**
 * @author huangzhibo
 * @date 10/10/2017
 */
public enum Elvis {

    INSTANE;

    private final String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

}
