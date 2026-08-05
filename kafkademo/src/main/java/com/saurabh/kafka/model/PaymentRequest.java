package com.saurabh.kafka.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PaymentRequest(
                @NotBlank String userId,
                @NotNull BigDecimal amount,
                @NotBlank String currency) {
}
