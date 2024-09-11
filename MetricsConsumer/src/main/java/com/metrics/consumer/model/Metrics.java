package com.metrics.consumer.model;

import com.metrics.consumer.dto.AppMetrics;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Представление метрики в БД<br>
 */
@Getter
@Setter
@Entity
@Table(name = "metrics")
@NoArgsConstructor
public class Metrics {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private Integer cpuLoad;

    @Column(nullable = false)
    private Long memoryUsage;

    @Column(nullable = false)
    private Integer threadCount;

    @Column(nullable = false)
    private Long totalRequests;

    @Column(nullable = false)
    private Long successfulRequests;

    @Column(nullable = false)
    private Long failedRequests;

    @Column(nullable = false)
    private Long averageResponseTime;

    @Column(nullable = false)
    private Integer totalExceptions;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    public Metrics(AppMetrics appMetrics) {
        this.cpuLoad = appMetrics.getCpuLoad();
        this.memoryUsage = appMetrics.getMemoryUsage();
        this.threadCount = appMetrics.getThreadCount();
        this.totalRequests = appMetrics.getHttpReport()
            .getTotalRequests();
        this.successfulRequests = appMetrics.getHttpReport()
            .getSuccessfulRequests();
        this.failedRequests = appMetrics.getHttpReport()
            .getFailedRequests();
        this.averageResponseTime = appMetrics.getHttpReport()
            .getAverageResponseTime();
        this.totalExceptions = appMetrics.getExceptions().size();
        this.dateTime = appMetrics.getDateTime();
    }
}
