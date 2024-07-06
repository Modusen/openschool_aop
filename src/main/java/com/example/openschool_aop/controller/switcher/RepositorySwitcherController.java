package com.example.openschool_aop.controller.switcher;

import com.example.openschool_aop.utils.RepositorySavingSwitcher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RepositorySwitcherController {

    @Autowired
    private RepositorySavingSwitcher repositorySavingSwitcher;

    @Operation(summary = "Switch repository saving function in runtime", tags = "switchers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")
    })
    @GetMapping("/switch_repository")
    public String switchRepositorySaving() {
        return "Repository saving is " + (repositorySavingSwitcher.switchProperty().equals("true") ? "enabled" : "disabled");
    }
}
