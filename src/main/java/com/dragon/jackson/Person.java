package com.dragon.jackson;

/**
 * @author huangzhibo
 * @date 24/07/2017
 */
public class Person {

    private String name;
    private Long identifyNumber;
    private int gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(Long identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
