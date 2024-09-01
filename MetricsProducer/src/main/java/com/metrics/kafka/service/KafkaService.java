package com.metrics.kafka.service;

import com.metrics.kafka.model.AppMetrics;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaService {

    private final String DEFAULT_TOPIC = "metrics-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(AppMetrics metrics) {
        kafkaTemplate.send(DEFAULT_TOPIC, metrics.toJson());
    }
}
