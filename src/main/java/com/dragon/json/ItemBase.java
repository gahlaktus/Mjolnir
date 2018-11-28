package com.dragon.json;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * @author huangzhibo
 * @date 25/09/2017
 */
public abstract class ItemBase {
    // todo: this method need to be refactored!!!
    abstract ItemBase convertString2MsgBase(String objStr) throws IOException;

    public String stringValue() throws JsonProcessingException {
        return JsonUtils.Object2JsonStr(this);
    }
}
