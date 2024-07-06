package com.example.openschool_aop.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ThreadUtils {

    public static void waitTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
