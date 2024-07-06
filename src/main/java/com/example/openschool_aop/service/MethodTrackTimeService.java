package com.example.openschool_aop.service;

import com.example.openschool_aop.model.dto.MethodTimeTrackDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MethodTrackTimeService {
    List<MethodTimeTrackDto> getAllMethodTimeTracks();

    Double getAllMethodsAverageTimeTrack();

    Double getMethodAverageTimeTrack(String methodName);

    Long getAllMethodsSummaryTimeTrack();
}
