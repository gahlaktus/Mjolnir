package com.dragon.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {


    private static final ObjectMapper mapper = new ObjectMapper();

    public static String Object2JsonStr(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T convertJsonStrTo(Class<T> tClass, String jsonStr) throws IOException {
        return mapper.readValue(jsonStr, tClass);
    }

}
