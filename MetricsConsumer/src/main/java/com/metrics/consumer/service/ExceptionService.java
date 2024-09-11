package com.metrics.consumer.service;

import com.metrics.consumer.model.ExceptionMetrics;
import com.metrics.consumer.model.Metrics;
import com.metrics.consumer.repository.ExceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExceptionService {
    private ExceptionRepository exceptionRepository;

    public List<ExceptionMetrics> getByMetricId(Metrics metrics) {
        return exceptionRepository.findByMetrics(metrics);
    }
}
