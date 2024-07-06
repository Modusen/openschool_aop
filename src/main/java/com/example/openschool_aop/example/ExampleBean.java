package com.example.openschool_aop.example;

import com.example.openschool_aop.annotation.TrackTime;
import com.example.openschool_aop.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class ExampleBean {

    @TrackTime
    public void info() {
        log.error("Собираем инфу");
        ThreadUtils.waitTime(ThreadLocalRandom.current().nextLong(150, 500));
        log.error("Выдаём инфу");
    }
}
