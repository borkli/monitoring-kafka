package com.metrics.kafka.model.report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpReport {
    private Long totalRequests;
    private Long successfulRequests;
    private Long failedRequests;
    private Long averageResponseTime;
}
