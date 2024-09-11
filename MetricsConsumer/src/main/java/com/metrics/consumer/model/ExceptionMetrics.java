package com.metrics.consumer.model;

import com.metrics.consumer.dto.report.ExceptionReport;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "exception_metrics")
@NoArgsConstructor
public class ExceptionMetrics {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String method;

    @Column
    private String type;
    @Column
    private String message;

    @ManyToOne
    @JoinColumn(name = "metric_id")
    private Metrics metrics;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    public ExceptionMetrics(ExceptionReport report, Metrics metrics) {
        this.method = report.getMethod();
        this.type = report.getType();
        this.message = report.getMessage();
        this.metrics = metrics;
        this.dateTime = metrics.getDateTime();
    }
}
