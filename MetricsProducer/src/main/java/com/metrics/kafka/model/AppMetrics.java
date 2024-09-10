package com.metrics.kafka.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metrics.kafka.model.report.ExceptionReport;
import com.metrics.kafka.model.report.HttpReport;
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

    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
