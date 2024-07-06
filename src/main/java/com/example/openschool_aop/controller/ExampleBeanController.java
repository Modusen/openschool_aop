package com.example.openschool_aop.controller;

import com.example.openschool_aop.example.AsyncExampleBean;
import com.example.openschool_aop.example.ExampleBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/example")
@RequiredArgsConstructor
public class ExampleBeanController {
    @Autowired
    private ExampleBean exampleBean;
    @Autowired
    private AsyncExampleBean asyncExampleBean;

    @Operation(summary = "Run info method", tags = "methods")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping("/info")
    public void startInfoMethod() {
        exampleBean.info();
    }

    @Operation(summary = "Run info method with async annotation", tags = "methods")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping("/info_async")
    public void startInfoMethodAsync() {
        asyncExampleBean.infoAsync();
    }
}
