package com.saurabh.practice.prepforboo.reportgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class LogProcessor {

    public static void main(String[] args) throws IOException {
        ReportAggregator reportAggregator = new ReportAggregator();
        final int bookingsCreated = 0,  successfulBookings = 0, failedBookings = 0, failedReasons = 0;

        Map<Enum, Integer> paymentMethods;
        Set<String> distinctUser;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
        );
        Path path = Path.of("/Users/saurabhnegi/Downloads/personal/A_Projects/JAVAProgrammingPractice2022/log.txt");

        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(line -> {
                        try {
                            LogEvent logEvent = objectMapper.readValue(line, LogEvent.class);
                            reportAggregator.accept(logEvent);
                        } catch (JsonProcessingException e){
                            System.err.println("Invalid JSON: " + line);
                        }
                    }
            );
        }

        System.out.println("=== Payment Operations Report ===");
        System.out.println("Total bookings created:"+ reportAggregator.getBookingsCreated());
        System.out.println("Payment attempts:"+ "succeeded="+reportAggregator.getSuccessfulBookings()+ ", failed="+reportAggregator.getFailedBookings());
    }
}
