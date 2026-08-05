package com.saurabh.kafka.exception;

public class FraudSuspectedException extends RuntimeException {
    public FraudSuspectedException(String message) {
        super(message);
    }
}
