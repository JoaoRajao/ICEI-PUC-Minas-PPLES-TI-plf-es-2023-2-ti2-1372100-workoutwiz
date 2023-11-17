package com.workoutwiz.api.utils;

import com.google.gson.Gson;

public class HttpResponseUtil {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
