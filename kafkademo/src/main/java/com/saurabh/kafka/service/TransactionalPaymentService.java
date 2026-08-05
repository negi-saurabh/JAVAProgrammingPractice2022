package com.saurabh.kafka.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.kafka.model.Payment;
import com.saurabh.kafka.model.PaymentEvent;
import com.saurabh.kafka.model.PaymentRequest;
import com.saurabh.kafka.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionalPaymentService {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    private final PaymentRepository paymentRepository; // saves to DB

    @Value("${app.kafka.topics.payment-events}")
    private String topic;

    @Transactional("transactionManager")
    public String processPayment(PaymentRequest req) {

        // Step 1 — create and save the Payment entity to DB
        Payment payment = Payment.builder()
                .id(UUID.randomUUID().toString())
                .userId(req.userId())
                .amount(req.amount())
                .currency(req.currency())
                .status("INITIATED")
                .createdAt(Instant.now())
                .build();

        paymentRepository.save(payment); // persisted to DB

        // Step 2 — publish to Kafka (no transaction wrapper)
        PaymentEvent event = PaymentEvent.initiated(
                payment.getId(), payment.getUserId(),
                payment.getAmount(), payment.getCurrency());

        kafkaTemplate.send(topic, payment.getUserId(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish event for paymentId={}", payment.getId(), ex);
                    } else {
                        log.info("Published event for paymentId={} partition={} offset={}",
                                payment.getId(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });

        return payment.getId();
    }

}
