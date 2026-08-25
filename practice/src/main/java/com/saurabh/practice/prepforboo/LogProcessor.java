package com.saurabh.practice.prepforboo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LogProcessor {

    public static void main(String[] args) {


        System.out.println("Saurabh");
    }

    class LogEvent {
        private LocalDateTime timestamp;
        private Type types;
        private String bookingId;
        private String paymentId;
        private String userId;
        private BigDecimal amount;
        private Currency currency;
        private Method method;

        // need it if payment fails
        private String reason;

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public Type getTypes() {
            return types;
        }

        public void setTypes(Type types) {
            this.types = types;
        }

        public String getBookingId() {
            return bookingId;
        }

        public void setBookingId(String bookingId) {
            this.bookingId = bookingId;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
