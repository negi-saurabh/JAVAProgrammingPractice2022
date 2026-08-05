package com.saurabh.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.saurabh.kafka.model.AuditEntry;
import com.saurabh.kafka.model.PaymentEvent;
import com.saurabh.kafka.repository.AuditRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuditLogConsumer {
    private final AuditRepository auditRepository;

    @KafkaListener(topics = "${app.kafka.topics.payment-events}", groupId = "audit-consumer")
    public void onPaymentEvent(PaymentEvent event, Acknowledgment ack) {
        AuditEntry entry = AuditEntry.builder().amount(event.amount()).build();
        auditRepository.save(entry);
        ack.acknowledge();
    }

}
