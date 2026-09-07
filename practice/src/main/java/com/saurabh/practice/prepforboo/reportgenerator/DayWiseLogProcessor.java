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
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;


public class DayWiseLogProcessor {
    private static final ZoneId REPORTING_ZONE = ZoneId.of("UTC");
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
        );

        TreeMap<LocalDate, ReportAggregator> dayWiseReport = new TreeMap<>();
        Path path = Path.of("/Users/saurabhnegi/Downloads/personal/A_Projects/JAVAProgrammingPractice2022/log.txt");

        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(line -> {
                        try {
                            LogEvent logEvent = objectMapper.readValue(line, LogEvent.class);
                            if (logEvent.getTimestamp() == null) {
                                System.err.println("Timestamp is missing: " + line);
                                return;
                            }
                            LocalDate date = logEvent.getTimestamp().atZone(REPORTING_ZONE).toLocalDate();
                            dayWiseReport.computeIfAbsent(date, d -> new ReportAggregator()).accept(logEvent);

                        } catch (JsonProcessingException e){
                            System.err.println("Invalid JSON: " + line);
                        } catch (NullPointerException e){
                            System.err.println("Timestamp is missing: " + line);
                        }
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("=== Payment Operations Report ===");
        dayWiseReport.entrySet().stream().forEach(entry -> {
                System.out.println("Total bookings created on ::" + entry.getKey() + ",  Total bookings created: " + entry.getValue().getBookingsCreated());
                System.out.println("Payment attempts:   "+ "succeeded="+entry.getValue().getSuccessfulBookings()+ ", failed="+entry.getValue().getFailedBookings());
                System.out.println("Failure reasons: ");
                entry.getValue().getFailedReasons().entrySet().stream().forEach(anotherEntry -> System.out.println("      "+anotherEntry.getKey()+" : "+ anotherEntry.getValue()));
                System.out.println("Payment methods used:  ");
                entry.getValue().getPaymentMethods().entrySet().stream().forEach(anotherEntry -> System.out.println("      "+anotherEntry.getKey()+" : "+ anotherEntry.getValue()));
                System.out.println("Distinct users: "+entry.getValue().getDistinctUser().size());
        });


    }

}
