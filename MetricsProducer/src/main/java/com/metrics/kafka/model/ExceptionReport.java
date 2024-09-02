package com.metrics.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionReport extends Report {
    private String type;
    private String message;
}
