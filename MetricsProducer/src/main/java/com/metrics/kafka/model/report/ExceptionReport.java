package com.metrics.kafka.model.report;

import lombok.Getter;
import lombok.Setter;

/**
 *  Отчёт о конкретной ошибке в приложении
 */
@Getter
@Setter
public class ExceptionReport {
    private String method;
    private String type;
    private String message;
}
