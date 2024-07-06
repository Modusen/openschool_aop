package com.example.openschool_aop.controller;

import com.example.openschool_aop.model.dto.MethodTimeTrackDto;
import com.example.openschool_aop.service.MethodTrackTimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MethodTrackTimeController {

    private final MethodTrackTimeService methodTrackTimeService;

    @Operation(summary = "Get all methods info", tags = "methods time tracks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MethodTimeTrackDto.class))})
    })
    @GetMapping("/all")
    public List<MethodTimeTrackDto> getAllMethodTimeTracks() {
        return methodTrackTimeService.getAllMethodTimeTracks();
    }

    @Operation(summary = "Get average completion time (ms) for all methods", tags = "methods time tracks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/avg_all")
    public double getAllMethodsAverageTimeTrack() {
        return methodTrackTimeService.getAllMethodsAverageTimeTrack();
    }

    @Operation(summary = "Get summary completion time (ms) for all methods", tags = "methods time tracks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/sum_all")
    public Long getAllMethodsSummaryTimeTrack() {
        return methodTrackTimeService.getAllMethodsSummaryTimeTrack();
    }

    @Operation(summary = "Get average completion time (ms) for specified method", tags = "methods time tracks")
    @Parameter(name = "methodName", description = "Use info OR infoAsync")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/avg")
    public double getMethodsAverageTimeTrack(@RequestParam(name = "methodName") String methodName) {
        return methodTrackTimeService.getMethodAverageTimeTrack(methodName);
    }

}
