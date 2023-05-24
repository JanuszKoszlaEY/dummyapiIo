package org.dummyapi.converter;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonConverter {
    private static final Gson GSON = new Gson();

    public static <T> String convertToJson(T object) {
        return GSON.toJson(object);
    }

    public static <T> T convertFromJson(String jString, Type type) {
        return GSON.fromJson(jString, type);
    }

}
