package com.dykj.webApi.utils;

import java.util.UUID;

/**
 * Created by fanbin on 2022/4/14
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
