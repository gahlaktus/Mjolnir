package com.dragon.keywords;

import java.io.Serializable;

/**
 * @author huangzhibo
 * @date 03/08/2017
 */
public class NameStore implements Serializable{

    private String firstName;
    private transient String middleName;
    private String lastName;

    public NameStore(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name : ")
        .append(this.firstName).append('\n')
        .append("Middle Name : ")
        .append(this.middleName).append('\n')
        .append("Last Name : ")
        .append(this.lastName);
        return sb.toString();
    }
}
