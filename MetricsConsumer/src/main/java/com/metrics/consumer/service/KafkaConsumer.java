package com.metrics.consumer.service;

import com.metrics.consumer.dto.AppMetrics;
import com.metrics.consumer.model.ExceptionMetrics;
import com.metrics.consumer.model.Metrics;
import com.metrics.consumer.repository.ExceptionRepository;
import com.metrics.consumer.repository.MetricsRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {

    private MetricsRepository metricsRepository;
    private ExceptionRepository exceptionRepository;

    private final String DEFAULT_TOPIC = "metrics-topic";

    @KafkaListener(topics = DEFAULT_TOPIC)
    public void listenMetrics(String jsonMetrics) {
        AppMetrics metrics = AppMetrics.fromJson(jsonMetrics);
        saveMetrics(metrics);
    }

    private void saveMetrics(AppMetrics appMetrics) {
        Metrics metrics = metricsRepository.saveAndFlush(
            new Metrics(appMetrics)
        );
        exceptionRepository.saveAllAndFlush(
            appMetrics.getExceptions().stream().map(
                ex -> new ExceptionMetrics(ex, metrics)
            ).toList()
        );
    }
}
