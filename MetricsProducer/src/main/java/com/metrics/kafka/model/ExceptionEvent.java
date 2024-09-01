package com.metrics.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionEvent extends Event {
    private String type;
    private String message;
}
