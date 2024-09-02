package com.metrics.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpReport extends Report {
    private int statusCode;
    private String httpMethod;
    private String url;
    private String request;
    private String response;
}
