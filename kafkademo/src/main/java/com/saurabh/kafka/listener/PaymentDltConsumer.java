package com.saurabh.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.saurabh.kafka.model.PaymentEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentDltConsumer {

    @KafkaListener(topics = "${app.kafka.topics.payment-dlt}", groupId = "dlt-handler")
    public void onDeadLetter(
            PaymentEvent event,
            @Header(KafkaHeaders.EXCEPTION_MESSAGE) String exceptionMessage,
            Acknowledgment ack) {

        log.error("DLT message received: eventId={} paymentId={} error={}",
                event.eventId(), event.paymentId(), exceptionMessage);

        // Alert ops team, write to incident table, trigger manual review, etc.
        // alertingService.sendAlert(event, exceptionMessage);
        ack.acknowledge();
    }

}
