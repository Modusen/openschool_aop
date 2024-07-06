package com.example.openschool_aop.service;

import com.example.openschool_aop.model.entity.MethodTimeTrackEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface AsyncSaverService {

    public MethodTimeTrackEntity saveEntityInAsyncMode(MethodTimeTrackEntity entity);
}
