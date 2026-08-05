package com.saurabh.kafka.listener;

import java.math.BigDecimal;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.saurabh.kafka.exception.FraudSuspectedException;
import com.saurabh.kafka.model.PaymentEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FraudDetectionConsumer {

    @KafkaListener(topics = "${app.kafka.topics.payment-events}", groupId = "fraud-consumer", containerFactory = "kafkaListenerContainerFactory")
    public void onPaymentEvent(PaymentEvent event,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset,
            Acknowledgment ack) {

        log.info("Fraud check: eventId={} userId={} amount={} partition={} offset={}",
                event.eventId(), event.userId(), event.amount(), partition, offset);

        try {
            checkForFraud(event);
            ack.acknowledge(); // commit offset only after successful processing
        } catch (FraudSuspectedException e) {
            log.warn("Fraud suspected for payment={}", event.paymentId());
            ack.acknowledge(); // still commit — fraud alert is handled, not a system error
        }
    }

    private void checkForFraud(PaymentEvent event) {
        // your fraud logic here — e.g. amount threshold, velocity checks
        if (event.amount().compareTo(new BigDecimal("10000")) > 0) {
            throw new FraudSuspectedException("High-value transaction: " + event.paymentId());
        }
    }

}
