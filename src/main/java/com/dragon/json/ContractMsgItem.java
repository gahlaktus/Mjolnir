package com.dragon.json;

import java.io.IOException;

/**
 * @author huangzhibo
 * @date 25/09/2017
 */
public class ContractMsgItem extends ItemBase{

    private String name;
    private int age;

    @Override
    ContractMsgItem convertString2MsgBase(String objStr) throws IOException {
        return JsonUtils.convertJsonStrTo(ContractMsgItem.class, objStr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
