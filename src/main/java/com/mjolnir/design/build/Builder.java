package com.mjolnir.design.build;

/**
 * @author huangzhibo
 * @date 2018/7/24
 */
public abstract class Builder {

    public abstract void buildCPU();

    public abstract void buildMainBoard();

    public abstract void buildHD();

    public abstract Computer getComputer();

}
