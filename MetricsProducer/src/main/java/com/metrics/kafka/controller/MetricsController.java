package com.metrics.kafka.controller;

import com.metrics.kafka.model.AppMetrics;
import com.metrics.kafka.service.KafkaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer/")
@AllArgsConstructor
public class MetricsController {

    private KafkaService kafkaService;

    @PostMapping("metrics")
    public void metrics(@RequestBody AppMetrics metrics) {
        kafkaService.send(metrics);
    }
}
