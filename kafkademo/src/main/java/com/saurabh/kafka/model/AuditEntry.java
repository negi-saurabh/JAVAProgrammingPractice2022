package com.saurabh.kafka.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntry {
    @Id
    String eventId;

    String paymentId;
    String userId;
    BigDecimal amount;
    String currency;
    String status;
    Instant occurredAt;
    Instant auditedAt;
}
