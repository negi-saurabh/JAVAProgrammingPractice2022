package com.saurabh.practice.prepforboo.avgbooking;

import java.util.ArrayList;
import java.util.List;

public class HotelBooking {
    record Booking(String userId, int checkIn, int checkOut) {}

    public static List<Integer> findLowBookingDates(
            List<Booking> bookings,
            int startDay,
            int endDay,
            double threshold) {

        // Difference array
        int[] diff = new int[endDay + 2];

        // Build booking changes
        for (Booking booking : bookings) {
            diff[booking.checkIn()]++;
            diff[booking.checkOut()]--;
        }

        // Calculate bookings for each day
        int[] bookingsPerDay = new int[endDay + 1];

        int activeBookings = 0;

        for (int day = startDay; day <= endDay; day++) {
            activeBookings += diff[day];
            bookingsPerDay[day] = activeBookings;
        }

        // Sliding window of 7 days
        List<Integer> result = new ArrayList<>();

        int windowSum = 0;

        for (int day = startDay; day <= endDay; day++) {

            windowSum += bookingsPerDay[day];

            // Remove the day that is now outside the 7-day window
            if (day >= startDay + 7) {
                windowSum -= bookingsPerDay[day - 7];
            }

            // We only evaluate once we have 7 days
            if (day >= startDay + 6) {

                double average = windowSum / 7.0;

                if (average < threshold) {
                    result.add(day);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Booking> bookings = List.of(
                new Booking("u1", 10, 12),
                new Booking("u2", 11, 14),
                new Booking("u3", 13, 15)
        );

        List<Integer> result =
                findLowBookingDates(
                        bookings,
                        8,
                        20,
                        1.0
                );

        System.out.println(result);
    }
}
