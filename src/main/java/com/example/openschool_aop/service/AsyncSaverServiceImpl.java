package com.example.openschool_aop.service;

import com.example.openschool_aop.model.entity.MethodTimeTrackEntity;
import com.example.openschool_aop.repository.MethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncSaverServiceImpl implements AsyncSaverService {
    @Autowired
    MethodRepository methodRepository;

    @Override
    public MethodTimeTrackEntity saveEntityInAsyncMode(MethodTimeTrackEntity entity){
        try {
            return CompletableFuture.supplyAsync(() -> {
                log.info("Сохраняем запись в асинхронном режиме {}", entity.toString());
                return methodRepository.save(entity);
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
