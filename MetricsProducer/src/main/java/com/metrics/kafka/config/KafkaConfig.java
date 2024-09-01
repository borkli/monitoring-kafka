package com.metrics.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic metricsTopic() {
        return new NewTopic("metrics-topic", 1, (short) 1);
    }
}
