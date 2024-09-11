package com.metrics.consumer.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metrics.consumer.dto.report.ExceptionReport;
import com.metrics.consumer.dto.report.HttpReport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AppMetrics {
    private Integer cpuLoad;
    private Long memoryUsage;
    private Integer threadCount;
    private HttpReport httpReport;
    private List<ExceptionReport> exceptions;
    private LocalDateTime dateTime;

    public static AppMetrics fromJson(String jsonMetrics) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(jsonMetrics, AppMetrics.class);
    }
}
