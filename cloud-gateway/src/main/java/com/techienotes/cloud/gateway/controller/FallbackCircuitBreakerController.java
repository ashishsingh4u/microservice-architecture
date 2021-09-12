package com.techienotes.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackCircuitBreakerController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod() {
        return "User Service is interrupted. It will fixed soon. Please try again after some time";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod() {
        return "Department Service is interrupted. It will fixed soon. Please try again after some time";
    }
}
