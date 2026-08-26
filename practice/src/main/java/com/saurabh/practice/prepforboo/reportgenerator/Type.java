package com.saurabh.practice.prepforboo.reportgenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {
        @JsonProperty("booking_created") BOOKING_CREATED,
        @JsonProperty("payment_attempted") PAYMENT_ATTEMPTED,
        @JsonProperty("payment_succeeded") PAYMENT_SUCCEEDED,
        @JsonProperty("payment_failed") PAYMENT_FAILED
}
