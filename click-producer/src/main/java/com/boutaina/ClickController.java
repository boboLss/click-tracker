package com.boutaina;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {
    private final KafkaProducerService producer;

    public ClickController(KafkaProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/click")
    public ResponseEntity<String> click(@RequestParam String userId) {
        producer.sendClick(userId);
        return ResponseEntity.ok("Click enregistré !");
    }
}
