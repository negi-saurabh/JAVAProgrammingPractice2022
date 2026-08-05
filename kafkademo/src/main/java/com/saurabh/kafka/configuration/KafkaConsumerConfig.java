package com.saurabh.kafka.configuration;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.ExponentialBackOff;

import com.saurabh.kafka.model.PaymentEvent;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentEvent> kafkaListenerContainerFactory(
            ConsumerFactory<String, PaymentEvent> consumerFactory,
            KafkaTemplate<String, PaymentEvent> kafkaTemplate) {

        var factory = new ConcurrentKafkaListenerContainerFactory<String, PaymentEvent>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties()
                .setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

        // retry with exponential backoff, then send to DLT
        var backOff = new ExponentialBackOff(1_000L, 2.0);
        backOff.setMaxElapsedTime(10_000L);

        var recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate,
                (record, ex) -> new TopicPartition(
                        record.topic() + ".DLT", record.partition()));

        var errorHandler = new DefaultErrorHandler(recoverer, backOff);
        errorHandler.addNotRetryableExceptions(IllegalArgumentException.class);

        factory.setCommonErrorHandler(errorHandler);
        return factory;
    }
}
