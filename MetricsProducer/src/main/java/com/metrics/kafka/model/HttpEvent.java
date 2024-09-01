package com.metrics.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpEvent extends Event {
    private int statusCode;
    private String request;
    private String response;
}
