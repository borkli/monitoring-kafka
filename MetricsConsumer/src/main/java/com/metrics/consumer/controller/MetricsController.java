package com.metrics.consumer.controller;

import com.metrics.consumer.model.ExceptionMetrics;
import com.metrics.consumer.model.Metrics;
import com.metrics.consumer.service.ExceptionService;
import com.metrics.consumer.service.MetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer/")
public class MetricsController {

    private MetricsService metricsService;
    private ExceptionService exceptionService;

    @GetMapping("metrics")
    private List<Metrics> metrics() {
        return metricsService.metrics();
    }

    @GetMapping("metrics/{id}")
    private Metrics getById(@PathVariable Long id) {
        return metricsService.getById(id);
    }

    @GetMapping("metrics/{id}/exceptions")
    private List<ExceptionMetrics> getByMetrics(@PathVariable Long id) {
        return exceptionService.getByMetricId(
            metricsService.getById(id)
        );
    }
}
