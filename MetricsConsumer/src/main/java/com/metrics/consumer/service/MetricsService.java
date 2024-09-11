package com.metrics.consumer.service;

import com.metrics.consumer.model.Metrics;
import com.metrics.consumer.repository.MetricsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricsService {

    private MetricsRepository metricsRepository;

    public List<Metrics> metrics() {
        return metricsRepository.findAll();
    }

    public Metrics getById(Long id) {
        return metricsRepository.findById(id).orElse(null);
    }
}
