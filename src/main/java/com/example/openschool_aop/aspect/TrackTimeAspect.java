package com.example.openschool_aop.aspect;

import com.example.openschool_aop.annotation.TrackTime;
import com.example.openschool_aop.model.entity.MethodTimeTrackEntity;
import com.example.openschool_aop.service.AsyncSaverService;
import com.example.openschool_aop.utils.AOPLoggingSwitcher;
import com.example.openschool_aop.utils.RepositorySavingSwitcher;
import com.example.openschool_aop.utils.TimeTracker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class TrackTimeAspect {
    @Autowired
    private AOPLoggingSwitcher aopLoggingFunction;
    @Autowired
    private RepositorySavingSwitcher repositorySavingFunction;
    @Autowired
    private AsyncSaverService asyncSaverService;

    @Pointcut("@annotation(trackTime)")
    public void trackTimePointcut(TrackTime trackTime) {
    }

    @Around("trackTimePointcut(trackTime)")
    public void aroundTrackTimeAdvice(ProceedingJoinPoint joinPoint, TrackTime trackTime) throws Throwable {
        Map<String, Long> timeValues = TimeTracker.calculateTime(joinPoint);
        if (aopLoggingFunction.getIsEnabled()) {
            log.info("Метод {} выполнен за {} мс", joinPoint.getSignature().getName(), (timeValues.get("finish") - timeValues.get("start")));
        }
        if (repositorySavingFunction.getIsEnabled()) {
            MethodTimeTrackEntity forSave = new MethodTimeTrackEntity(null,
                    joinPoint.getSignature().getName(),
                    joinPoint.getSignature().getDeclaringType().toString().split("openschool_aop\\.")[1],
                    (timeValues.get("finish") - timeValues.get("start")),
                    LocalDateTime.now());
            MethodTimeTrackEntity saved = asyncSaverService.saveEntityInAsyncMode(forSave);
            log.info("Сохраненная сущность: {}", saved.toString());
        }
    }
}
