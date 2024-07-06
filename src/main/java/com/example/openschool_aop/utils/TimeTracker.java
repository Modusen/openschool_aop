package com.example.openschool_aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TimeTracker {
    public static Map<String, Long> calculateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long finish = System.currentTimeMillis();
        return new HashMap<>() {{
            put("start", start);
            put("finish", finish);
        }};
    }
}
