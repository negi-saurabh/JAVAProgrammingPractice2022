package com.saurabh.practice.prepforboo.reportgenerator;

import java.math.BigDecimal;
import java.util.*;

public class ReportAggregator {

    private int bookingsCreated;

    private int successfulBookings;

    private int failedBookings;

    private List<String> failedReasons = new ArrayList<>();

    private Map<Enum, Integer> paymentMethods = new HashMap<>();

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

    public List<String> getFailedReasons() {
        return failedReasons;
    }

    public void setFailedReasons(List<String> failedReasons) {
        this.failedReasons = failedReasons;
    }

    public Map<Enum, Integer> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Map<Enum, Integer> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Set<String> getDistinctUser() {
        return distinctUser;
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

        if (event.getReason() != null)
            failedReasons.add(event.getReason());

        paymentMethods.merge(event.getType(), 1, Integer::sum);
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
