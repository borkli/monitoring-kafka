package com.metrics.consumer.repository;

import com.metrics.consumer.model.ExceptionMetrics;
import com.metrics.consumer.model.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExceptionRepository extends JpaRepository<ExceptionMetrics, Long> {

    List<ExceptionMetrics> findByMetrics(Metrics metrics);
}
