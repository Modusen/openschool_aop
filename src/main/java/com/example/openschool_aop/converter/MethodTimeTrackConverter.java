package com.example.openschool_aop.converter;

import com.example.openschool_aop.model.dto.MethodTimeTrackDto;
import com.example.openschool_aop.model.entity.MethodTimeTrackEntity;
import org.springframework.stereotype.Component;

@Component
public class MethodTimeTrackConverter {
    public static MethodTimeTrackDto convertToDto(MethodTimeTrackEntity entity) {
        return new MethodTimeTrackDto(entity.getId(),
                entity.getMethodName(),
                entity.getMethodGroup(),
                entity.getCompletionTime(),
                entity.getCompletionDate()
        );
    }

    public static MethodTimeTrackEntity convertToEntity(MethodTimeTrackDto dto) {
        return new MethodTimeTrackEntity(dto.getId(),
                dto.getMethodName(),
                dto.getMethodGroup(),
                dto.getCompletionTime(),
                dto.getCompletionDate()
        );
    }
}
