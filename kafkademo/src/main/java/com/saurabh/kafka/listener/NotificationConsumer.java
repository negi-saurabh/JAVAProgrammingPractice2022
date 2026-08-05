package com.saurabh.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.saurabh.kafka.model.PaymentEvent;
import com.saurabh.kafka.service.NotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "${app.kafka.topics.payment-events}", groupId = "notify-consumer")
    public void onPaymentEvent(PaymentEvent event, Acknowledgment ack) {
        if ("COMPLETED".equals(event.status())) {
            notificationService.sendConfirmation(event.userId(), event.paymentId());
        }
        ack.acknowledge();
    }

}
