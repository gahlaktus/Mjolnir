package com.mjolnir.design.build;

/**
 * @author huangzhibo
 * @date 2018/7/24
 */
public class Director {

    public void construct(Builder builder){
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }

}
