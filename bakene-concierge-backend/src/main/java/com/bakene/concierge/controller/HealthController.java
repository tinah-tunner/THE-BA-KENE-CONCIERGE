package com.bakene.concierge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public String health() {
        return "THE BA KENE CONCIERGE Backend is running successfully!";
    }
}