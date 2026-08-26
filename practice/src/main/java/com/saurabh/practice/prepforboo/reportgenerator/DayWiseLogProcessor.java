package com.saurabh.practice.prepforboo.reportgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Stream;


public class DayWiseLogProcessor {
    private static final ZoneId REPORTING_ZONE = ZoneId.of("UTC");
    public static void main(String[] args) {
        ReportAggregator reportAggregator = new ReportAggregator();
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
                            LocalDate date = logEvent.getTimestamp().atZone(REPORTING_ZONE).toLocalDate();

                            reportAggregator.accept(logEvent);
                        } catch (JsonProcessingException e){
                            System.err.println("Invalid JSON: " + line);
                        }
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=== Payment Operations Report ===");
        System.out.println("Total bookings created:"+ reportAggregator.getBookingsCreated());
        System.out.println("Payment attempts:   "+ "succeeded="+reportAggregator.getSuccessfulBookings()+ ", failed="+reportAggregator.getFailedBookings());
        System.out.println("Failure reasons: ");
        reportAggregator.getFailedReasons().entrySet().stream().forEach(entry -> System.out.println("      "+entry.getKey()+" : "+ entry.getValue()));
        System.out.println("Payment methods used:  ");
        reportAggregator.getPaymentMethods().entrySet().stream().forEach(entry -> System.out.println("      "+entry.getKey()+" : "+ entry.getValue()));
        System.out.println("Distinct users: "+reportAggregator.getDistinctUser().size());
        ;
    }

}
