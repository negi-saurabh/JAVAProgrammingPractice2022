package com.saurabh.practice.prepforboo.reportgenerator;

import java.math.BigDecimal;
import java.util.*;

public class ReportAggregator {

    private int bookingsCreated;

    private int successfulBookings;

    private int failedBookings;

    private Map<String, Integer> failedReasons = new HashMap<>();

    private Map<Method, Integer> paymentMethods = new HashMap<>();

    private Set<String> distinctUser= new HashSet<>();

    private BigDecimal totalAmount = BigDecimal.ZERO;

    public int getBookingsCreated() {
        return bookingsCreated;
    }

    public void setBookingsCreated(int bookingsCreated) {
        this.bookingsCreated = bookingsCreated;
    }

    public int getSuccessfulBookings() {
        return successfulBookings;
    }

    public void setSuccessfulBookings(int successfulBookings) {
        this.successfulBookings = successfulBookings;
    }

    public int getFailedBookings() {
        return failedBookings;
    }

    public void setFailedBookings(int failedBookings) {
        this.failedBookings = failedBookings;
    }

    public Map<String, Integer> getFailedReasons() {
        return  Map.copyOf(failedReasons);
    }

    public void setFailedReasons(Map<String, Integer> failedReasons) {
        this.failedReasons = failedReasons;
    }

    public Map<Method, Integer> getPaymentMethods() {
        return  Map.copyOf(paymentMethods);
    }

    public void setPaymentMethods(Map<Method, Integer> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Set<String> getDistinctUser() {
        return  Set.copyOf(distinctUser);
    }

    public void setDistinctUser(Set<String> distinctUser) {
        this.distinctUser = distinctUser;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void accept(LogEvent event){

        if(Type.PAYMENT_SUCCEEDED.equals(event.getType()))
            successfulBookings++;

        if(Type.PAYMENT_FAILED.equals(event.getType()))
            failedBookings++;

        if (event.getReason() != null) {
            failedReasons.merge(event.getReason(), 1, Integer::sum);
        }

        if (event.getMethod() != null) {
            paymentMethods.merge(event.getMethod(), 1, Integer::sum);
        }
        if (event.getUserId() != null)
            distinctUser.add(event.getUserId());

        if (event.getType() == Type.BOOKING_CREATED) {
            bookingsCreated++;

            if (event.getAmount() != null) {
                totalAmount = totalAmount.add(event.getAmount());
            }
        }
    }

}
