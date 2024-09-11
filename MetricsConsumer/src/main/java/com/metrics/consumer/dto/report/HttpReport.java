package com.metrics.consumer.dto.report;

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
