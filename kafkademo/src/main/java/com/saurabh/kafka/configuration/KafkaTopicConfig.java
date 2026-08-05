package com.saurabh.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${app.kafka.topics.payment-events}")
    private String paymentEventsTopic;

    @Value("${app.kafka.topics.payment-dlt}")
    private String paymentDltTopic;

    @Bean
    public NewTopic paymentEventsTopic() {
        return TopicBuilder
                .name(paymentEventsTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic paymentDltTopic() {
        return TopicBuilder
                .name(paymentDltTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
