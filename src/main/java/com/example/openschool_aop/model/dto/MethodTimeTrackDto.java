package com.example.openschool_aop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MethodTimeTrackDto {
    private Long id;

    private String methodName;

    private String methodGroup;

    private Long completionTime;

    private LocalDateTime completionDate;
}
