package com.dragon.reflect;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huangzhibo
 * @date 30/06/2017
 */
public class ADTO {
    private String name;
    private Integer age;
    private BigDecimal salary;

    private List<EoGirlFriendDTO> eoGirlFriends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<EoGirlFriendDTO> getEoGirlFriends() {
        return eoGirlFriends;
    }

    public void setEoGirlFriends(List<EoGirlFriendDTO> eoGirlFriends) {
        this.eoGirlFriends = eoGirlFriends;
    }
}
