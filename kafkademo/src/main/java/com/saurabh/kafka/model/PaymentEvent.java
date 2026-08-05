package com.saurabh.kafka.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PaymentEvent(
        String eventId, // idempotency key
        String paymentId,
        String userId,
        BigDecimal amount,
        String currency, // "EUR", "USD"
        String status, // "INITIATED", "COMPLETED", "FAILED"
        Instant occurredAt) {

    public static PaymentEvent initiated(String paymentId, String userId,
            BigDecimal amount, String currency) {
        return new PaymentEvent(
                UUID.randomUUID().toString(),
                paymentId, userId, amount, currency,
                "INITIATED", Instant.now());
    }
}