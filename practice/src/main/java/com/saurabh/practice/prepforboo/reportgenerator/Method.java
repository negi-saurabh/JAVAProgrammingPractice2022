package com.saurabh.practice.prepforboo.reportgenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Method {
        @JsonProperty("credit_card")
        CREDIT_CARD,

        @JsonProperty("paypal")
        PAYPAL,
}
