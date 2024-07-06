package com.example.openschool_aop.service;

import com.example.openschool_aop.converter.MethodTimeTrackConverter;
import com.example.openschool_aop.model.dto.MethodTimeTrackDto;
import com.example.openschool_aop.repository.MethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MethodTrackTimeServiceImpl implements MethodTrackTimeService {

    private final MethodRepository methodRepository;

    @Override
    public List<MethodTimeTrackDto> getAllMethodTimeTracks() {
        return methodRepository.findAll()
                .stream()
                .map(MethodTimeTrackConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Double getAllMethodsAverageTimeTrack() {
        return methodRepository.findAvgTimeForAllMethods();
    }

    @Override
    public Double getMethodAverageTimeTrack(String methodName) {
        return methodRepository.findAvgTimeForMethod(methodName);
    }

}
