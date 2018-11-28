package com.mjolnir.design.build;

/**
 * @author huangzhibo
 * @date 2018/7/24
 */
public class ConcreteBuilder extends Builder{

    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.add("cpu");
    }

    @Override
    public void buildMainBoard() {
        computer.add("main-board");
    }

    @Override
    public void buildHD() {
        computer.add("hd");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
