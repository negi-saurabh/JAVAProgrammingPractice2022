package com.saurabh.practice.prepforboo.reportgenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Currency {
        @JsonProperty("EUR")
        EUR,
        @JsonProperty("USD")
        USD,
        @JsonProperty("INR")
        INR
}
