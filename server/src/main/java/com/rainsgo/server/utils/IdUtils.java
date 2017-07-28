package com.rainsgo.server.utils;

import java.util.UUID;

public class IdUtils {
    public static String generateUUID(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
