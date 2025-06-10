package com.boutaina.controller;

import com.boutaina.service.ClickConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/clicks")
public class ClickRestController {
    private final ClickConsumerService service;

    public ClickRestController(ClickConsumerService service) {
        this.service = service;
    }

    @GetMapping("/count")
    public Map<String, Long> getCounts() {
        return service.getAllCounts();
    }
}

