package com.example.openschool_aop.example;

import com.example.openschool_aop.annotation.TrackAsyncTime;
import com.example.openschool_aop.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class AsyncExampleBean {

    @TrackAsyncTime
    public void infoAsync() {
        log.error("Собираем инфу");
        ThreadUtils.waitTime(ThreadLocalRandom.current().nextLong(150, 500));
        log.error("Выдаём инфу");
    }
}
