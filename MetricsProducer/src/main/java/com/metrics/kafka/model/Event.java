package com.metrics.kafka.model;

import java.time.LocalDateTime;

public abstract class Event {
    protected Long id;
    protected LocalDateTime dateTime;
}
