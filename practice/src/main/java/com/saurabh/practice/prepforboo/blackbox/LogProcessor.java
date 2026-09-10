package com.saurabh.practice.prepforboo.blackbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LogProcessor {

    private static Instant maxInstant = Instant.MIN;
    private static DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
    private static int intervalUnits = 30;
    private static Path outputPath = Path.of("/Users/saurabhnegi/Downloads/personal/A_Projects/JAVAProgrammingPractice2022/practice/src/main/java/com/saurabh/practice/prepforboo/blackbox/output/outputfile.txt") ;
    public static void main(String[] args) {
        List<String> lineList = new ArrayList<>();
        Path folderPath = Path.of("/Users/saurabhnegi/Downloads/personal/A_Projects/JAVAProgrammingPractice2022/practice/src/main/java/com/saurabh/practice/prepforboo/blackbox/data");
        calculateMaxTime(folderPath);
        compareAndExtractResult(folderPath);

        Path outputFileForSorting = outputPath;
        try(Stream<String> lines = Files.lines(outputFileForSorting)){
            lines.forEach(line -> {
                lineList.add(line);
            });
            lineList.sort(Comparator.comparing(line ->getInstant(line).orElse(Instant.MIN)));
            lineList.forEach(l-> System.out.println("Lines"+l));
        }catch (IOException e){
            System.err.println("Error while sorting"+e);
        }

    }

    private static void compareAndExtractResult(Path folderPath) {
        try(BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)){
            try (Stream<Path> files = Files.list(folderPath)) {
                files.forEach(file -> {
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(line -> {
                            getInstant(line).ifPresent(instant -> {
                                if (!instant.isBefore(maxInstant.minus(intervalUnits, ChronoUnit.MINUTES))) {
                                    try {
                                        writer.write(line);
                                        writer.newLine();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        });
                    } catch (IOException e) {
                        System.err.println("Error while outputting File" + file);
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Problem in reading file path");
        }
    }

    private static void calculateMaxTime(Path folderPath) {
        try (Stream<Path> files = Files.list(folderPath)) {
            files.forEach(file -> {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.forEach(line -> {
                        getInstant(line).ifPresent(instant ->{
                            if(maxInstant.isBefore(instant))
                                maxInstant = instant;
                        } );

                    });
                } catch (IOException e) {
                    System.err.println("Invalid File" + file);
                }
            });
        } catch (IOException e) {
            System.err.println("Problem in reading file path");
        }
    }

    private static Optional<Instant> getInstant(String line) {
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isLetter(line.charAt(i))) {
                    break;
                }
                builder.append(line.charAt(i));
            }
            String timestamp = builder.toString().trim();

            // validate timestamp
            LocalDateTime localDateTime = LocalDateTime.parse(timestamp, dateTimeFormatter);
            return Optional.of(localDateTime.toInstant(ZoneOffset.UTC));
        } catch (DateTimeParseException e){
            System.err.println("Error while processing Date"+e);
            return Optional.empty();
        }
    }

}
