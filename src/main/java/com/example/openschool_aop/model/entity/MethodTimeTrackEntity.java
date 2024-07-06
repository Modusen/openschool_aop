package com.example.openschool_aop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TIME_TRACK")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MethodTimeTrackEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "METHOD_NAME")
    private String methodName;

    @Column(name = "METHOD_GROUP")
    private String methodGroup;

    @Column(name = "COMPLETION_TIME")
    private Long completionTime;

    @Column(name = "COMPLETION_DATE")
    private LocalDateTime completionDate;

}
